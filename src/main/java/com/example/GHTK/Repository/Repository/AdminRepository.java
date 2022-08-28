package com.example.GHTK.Repository.Repository;

import com.example.GHTK.Model.AdminRight.Service;
import com.example.GHTK.Model.AdminRight.TimeLine;
import com.example.GHTK.Model.AdminRight.Type;
import com.example.GHTK.Model.Custom.OrderDetails;
import com.example.GHTK.Model.AdminRight.Area;
import com.example.GHTK.Model.Status.Response;
import com.example.GHTK.Model.UserRight.Customer;
import com.example.GHTK.Model.UserRight.Order;
import com.example.GHTK.Model.UserRight.Shipper;
import com.example.GHTK.Repository.Manager.AdminManager;
import com.example.GHTK.Ultilities.Database;
import com.example.GHTK.Ultilities.ValidateMail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.util.List;

public class AdminRepository implements AdminManager {
    private static final Database database = Database.getDatabase();
    private static final Connection connection = database.getConnection();

    public static AdminRepository repository;

    public static AdminRepository getRepository() {
        if (repository == null) {
            repository = new AdminRepository();
        }
        return repository;
    }

    /*
    POST API (rights only) for admin account
     */
    @Override
    public Object insert(Area area) throws SQLException {
        Object object = null;
        if (area == null) {
            object = new Response(false, "We dont accept null information here");
        }
        /*
        Date time create and add this field
         */
        String time_created = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        String insert = "INSERT INTO GHTK.areas(id_area,name_area,time_created) VALUES (?,?,?)";

        String lastRecord = "SELECT id_area FROM GHTK.areas ORDER BY id_area DESC LIMIT 1;";
        PreparedStatement lastRecordPS = connection.prepareStatement(lastRecord);
        ResultSet resultLastRecord = lastRecordPS.executeQuery();

        String check = "SELECT name_area FROM GHTK.areas WHERE name_area = '" + area.getNameArea() + "';";
        PreparedStatement checkPS = connection.prepareStatement(check);
        ResultSet resultCheck = checkPS.executeQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            if (resultCheck.next()) {
                object = new Response(false, "Duplicated value in database");
            } else {
                if (resultLastRecord.next()) {
                    String tempId = resultLastRecord.getString(1).replaceAll("[a-zA-Z]+", "");
                    Integer num = Integer.parseInt(tempId) + 1;

                    preparedStatement.setString(1, "KV" + num);
                } else {
                    preparedStatement.setString(1, "KV1");
                }
                preparedStatement.setString(2, area.getNameArea());
                preparedStatement.setString(3, time_created);
                preparedStatement.executeUpdate();
                object = new Response(true, area);
            }
        } catch (Exception e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object insert(Service service) throws SQLException {
        Object object = null;
        if (service == null) {
            object = new Response(false, "We dont accept null information here");
        }
        /*
        Date time create and add this field
         */
        String time_created = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        String insert = "INSERT INTO GHTK.services(id_service,name_service,time_created) VALUES (?,?,?)";

        String lastRecord = "SELECT id_service FROM GHTK.services ORDER BY id_service DESC LIMIT 1;";
        PreparedStatement lastRecordPS = connection.prepareStatement(lastRecord);
        ResultSet resultLastRecord = lastRecordPS.executeQuery();

        String check = "SELECT name_service FROM GHTK.services WHERE name_service = '" + service.getNameService() + "';";
        PreparedStatement checkPS = connection.prepareStatement(check);
        ResultSet resultCheck = checkPS.executeQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            if (resultCheck.next()) {
                object = new Response(false, "Duplicated value in database");
            } else {
                if (resultLastRecord.next()) {
                    String tempId = resultLastRecord.getString(1).replaceAll("[a-zA-Z]+", "");
                    Integer num = Integer.parseInt(tempId) + 1;

                    preparedStatement.setString(1, "DV" + num);
                } else {
                    preparedStatement.setString(1, "DV1");
                }
                preparedStatement.setString(2, service.getNameService());
                preparedStatement.setString(3, time_created);
                preparedStatement.executeUpdate();
                object = new Response(true, service);
            }
        } catch (Exception e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object insert(TimeLine timeLine) throws SQLException {
        Object object = null;
        if (timeLine == null) {
            object = new Response(false, "We dont accept null information here");
        }
        /*
        Date time create and add this field
         */
        String time_created = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        String insert = "INSERT INTO GHTK.timeline(id_time,description_time,time_created) VALUES (?,?,?)";

        String lastRecord = "SELECT id_time FROM GHTK.timeline ORDER BY id_time DESC LIMIT 1;";
        PreparedStatement lastRecordPS = connection.prepareStatement(lastRecord);
        ResultSet resultLastRecord = lastRecordPS.executeQuery();

        String check = "SELECT description_time FROM GHTK.timeline WHERE description_time = '" + timeLine.getDescription() + "';";
        PreparedStatement checkPS = connection.prepareStatement(check);
        ResultSet resultCheck = checkPS.executeQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            if (resultCheck.next()) {
                object = new Response(false, "Duplicated value in database");
            } else {
                if (resultLastRecord.next()) {
                    String tempId = resultLastRecord.getString(1).replaceAll("[a-zA-Z]+", "");
                    Integer num = Integer.parseInt(tempId) + 1;

                    preparedStatement.setString(1, "TG" + num);
                } else {
                    preparedStatement.setString(1, "TG1");
                }
                preparedStatement.setString(2, timeLine.getDescription());
                preparedStatement.setString(3, time_created);
                preparedStatement.executeUpdate();
                object = new Response(true, timeLine);
            }
        } catch (Exception e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object insert(Type type) throws SQLException {
        Object object = null;
        if (type == null) {
            object = new Response(false, "We dont accept null information here");
        }
        /*
        Date time create and add this field
         */
        String time_created = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        String insert = "INSERT INTO GHTK.types(id_type,name_type,time_created) VALUES (?,?,?)";

        String lastRecord = "SELECT id_type FROM GHTK.types ORDER BY id_type DESC LIMIT 1;";
        PreparedStatement lastRecordPS = connection.prepareStatement(lastRecord);
        ResultSet resultLastRecord = lastRecordPS.executeQuery();

        String check = "SELECT name_type FROM GHTK.types WHERE name_type = '" + type.getNameProduct() + "';";
        PreparedStatement checkPS = connection.prepareStatement(check);
        ResultSet resultCheck = checkPS.executeQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            if (resultCheck.next()) {
                object = new Response(false, "Duplicated value in database");
            } else {
                if (resultLastRecord.next()) {
                    String tempId = resultLastRecord.getString(1).replaceAll("[a-zA-Z]+", "");
                    Integer num = Integer.parseInt(tempId) + 1;

                    preparedStatement.setString(1, "MH" + num);
                } else {
                    preparedStatement.setString(1, "MH1");
                }
                preparedStatement.setString(2, type.getNameProduct());
                preparedStatement.setString(3, time_created);
                preparedStatement.executeUpdate();
                object = new Response(true, type);
            }
        } catch (Exception e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    /*
    GET API (rights only) for admin account
     */
    @Override
    public Object queryArea() {
        Object object = null;
        List<Area> areaList = new ArrayList<>();

        String query = "SELECT * FROM GHTK.areas;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                Area area = new Area(resultSet.getString("name_area"));
                areaList.add(area);
            }
            object = new Response(true, areaList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object queryAreaById(String id_area) {
        Object object = null;
        Area area = null;
        String query = "SELECT * FROM GHTK.areas WHERE id_area ='" + id_area + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()) {
                area = new Area(resultSet.getString("name_area"));
                object = new Response(true, area);
            } else {
                object = new Response(false, "No area with this id");
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object queryTime() {
        Object object;
        List<TimeLine> timeList = new ArrayList<>();

        String query = "SELECT * FROM GHTK.timeline;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                TimeLine time = new TimeLine(resultSet.getString("description_time"));
                timeList.add(time);
            }
            object = new Response(true, timeList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object queryTimeById(String id) {
        Object object = null;
        TimeLine timeLine = null;
        String query = "SELECT * FROM GHTK.timeline WHERE id_time ='" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()) {
                timeLine = new TimeLine(resultSet.getString("description_time"));
                object = new Response(true, timeLine);
            } else {
                object = new Response(false, "No time with this id");
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object queryService() {
        Object object = null;
        List<Service> serviceList = new ArrayList<>();

        String query = "SELECT * FROM GHTK.services;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                Service service = new Service(resultSet.getString("name_service"));
                serviceList.add(service);
            }
            object = new Response(true, serviceList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object queryServiceById(String id) {
        Object object = null;
        Service service = null;
        String query = "SELECT * FROM GHTK.services WHERE id_service ='" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()) {
                service = new Service(resultSet.getString("name_service"));
                object = new Response(true, service);
            } else {
                object = new Response(false, "No service with this id");
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object queryType() {
        Object object = null;
        List<Type> typeList = new ArrayList<>();

        String query = "SELECT * FROM GHTK.types;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                Type type = new Type(resultSet.getString("name_type"));
                typeList.add(type);
            }
            object = new Response(true, typeList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object queryTypeById(String id) {
        Object object = null;
        Type type = null;
        String query = "SELECT * FROM GHTK.types WHERE id_type ='" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()) {
                type = new Type(resultSet.getString("name_type"));
                object = new Response(true, type);
            } else {
                object = new Response(false, "No type with this id");
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object queryCustomer() {
        Object object = null;
        List<Customer> customerList = new ArrayList<>();

        String query = "SELECT * FROM GHTK.customers;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                Customer customer = new Customer(resultSet.getString("id_customer"),
                        resultSet.getString("name_customer"),
                        resultSet.getString("name_shop_customer"),
                        resultSet.getString("area_customer"),
                        resultSet.getString("number_customer"),
                        resultSet.getString("address_customer"),
                        resultSet.getString("mail_customer"),
                        resultSet.getString("taxcode_customer"));
                customerList.add(customer);
            }
            object = new Response(true, customerList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object queryCustomerById(String id) {
        Object object = null;
        Customer customer = null;
        String query = "SELECT * FROM GHTK.customers WHERE id_customer ='" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()) {
                customer = new Customer(resultSet.getString("id_customer"),
                        resultSet.getString("name_customer"),
                        resultSet.getString("name_shop_customer"),
                        resultSet.getString("area_customer"),
                        resultSet.getString("number_customer"),
                        resultSet.getString("address_customer"),
                        resultSet.getString("mail_customer"),
                        resultSet.getString("taxcode_customer"));
                object = new Response(true, customer);
            } else {
                object = new Response(false, "No customer with this id");
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object queryShipper() {
        Object object = null;
        List<Shipper> shipperList = new ArrayList<>();

        String query = "SELECT * FROM GHTK.shippers;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                Shipper shipper = new Shipper(resultSet.getString("id_shipper"),
                        resultSet.getString("name_shipper"),
                        resultSet.getString("born_shipper"),
                        resultSet.getBoolean("gender_shipper"),
                        resultSet.getString("number_shipper"),
                        resultSet.getString("address_shipper"),
                        resultSet.getString("mail_shipper"));
                shipperList.add(shipper);
            }
            object = new Response(true, shipperList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object queryShipperById(String id) {
        Object object = null;
        Shipper shipper = null;
        String query = "SELECT * FROM GHTK.shippers WHERE id_shipper ='" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()) {
                shipper = new Shipper(resultSet.getString("id_shipper"),
                        resultSet.getString("name_shipper"),
                        resultSet.getString("born_shipper"),
                        resultSet.getBoolean("gender_shipper"),
                        resultSet.getString("number_shipper"),
                        resultSet.getString("address_shipper"),
                        resultSet.getString("mail_shipper"));
                object = new Response(true, shipper);
            } else {
                object = new Response(false, "No shipper with this id");
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    /*
       Get information about order(name instead of id),...etc
    */
    @Override
    public Object queryOrder() {
        Object object = null;
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        String query = "SELECT B.name_shop_customer as name_shop_customer, B.number_customer as numberShop\n" +
                "\t, B.address_customer as addressShop , A.daytime_order as daytime_order\n" +
                "    , A.name_receiver_order as name_receiver_order, A.number_receiver_order as number_receiver_order\n" +
                "    , A.address_receiver_order as address_receiver_order, D.name_shipper as name_shipper\n" +
                "    , D.number_shipper as number_shipper, A.name_order as name_order\n" +
                "    , A.cost_order as cost_order, F.name_type as typeOrder\n" +
                "    , E.description_time as description_time, C.name_service as name_service\n" +
                "    , A.approve_order as approve_order, A.status_deliver_order as status_deliver_order, A.available_order as available_order\n" +
                "   FROM GHTK.orders as A INNER JOIN GHTK.customers as B ON A.id_shop_order = B.id_customer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.services as C ON A.id_service_order = C.id_service\n" +
                "                     INNER JOIN GHTK.shippers as D ON A.id_shipper_order = D.id_shipper\n" +
                "                     INNER JOIN GHTK.timeline as E ON A.id_time_order = E.id_time\n" +
                "                     INNER JOIN GHTK.types as F ON A.id_type_order = F.id_type;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("name_shop_customer"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daytime_order"),
                        resultSet.getString("name_receiver_order"),
                        resultSet.getString("number_receiver_order"),
                        resultSet.getString("address_receiver_order"),
                        resultSet.getString("name_shipper"),
                        resultSet.getString("number_shipper"),
                        resultSet.getString("name_order"),
                        resultSet.getInt("cost_order"),
                        resultSet.getString("name_type"),
                        resultSet.getString("description_time"),
                        resultSet.getString("name_service"),
                        resultSet.getBoolean("approve_order"),
                        resultSet.getBoolean("status_deliver_order"),
                        resultSet.getBoolean("available_order"));
                orderDetailsList.add(orderDetails);
            }
            object = new Response(true, orderDetailsList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    /*
    By idOrder
     */
    @Override
    public Object queryOrderByIdOrder(String id) {
        Object object = null;
        OrderDetails orderDetails;

        String query = "SELECT B.name_shop_customer as name_shop_customer, B.number_customer as numberShop\n" +
                "\t, B.address_customer as addressShop , A.daytime_order as daytime_order\n" +
                "    , A.name_receiver_order as name_receiver_order, A.number_receiver_order as number_receiver_order\n" +
                "    , A.address_receiver_order as address_receiver_order, D.name_shipper as name_shipper\n" +
                "    , D.number_shipper as number_shipper, A.name_order as name_order\n" +
                "    , A.cost_order as cost_order, F.name_type as typeOrder\n" +
                "    , E.description_time as description_time, C.name_service as name_service\n" +
                "    , A.approve_order as approve_order, A.status_deliver_order as status_deliver_order, A.available_order as available_order\n" +
                "   FROM GHTK.orders as A INNER JOIN GHTK.customers as B ON A.id_shop_order = B.id_customer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.services as C ON A.id_service_order = C.id_service\n" +
                "                     INNER JOIN GHTK.shippers as D ON A.id_shipper_order = D.id_shipper\n" +
                "                     INNER JOIN GHTK.timeline as E ON A.id_time_order = E.id_time\n" +
                "                     INNER JOIN GHTK.types as F ON A.id_type_order = F.id_type" +
                "   WHERE A.id_order = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()) {
                orderDetails = new OrderDetails(resultSet.getString("name_shop_customer"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daytime_order"),
                        resultSet.getString("name_receiver_order"),
                        resultSet.getString("number_receiver_order"),
                        resultSet.getString("address_receiver_order"),
                        resultSet.getString("name_shipper"),
                        resultSet.getString("number_shipper"),
                        resultSet.getString("name_order"),
                        resultSet.getInt("cost_order"),
                        resultSet.getString("name_type"),
                        resultSet.getString("description_time"),
                        resultSet.getString("name_service"),
                        resultSet.getBoolean("approve_order"),
                        resultSet.getBoolean("status_deliver_order"),
                        resultSet.getBoolean("available_order"));
                object = new Response(true, orderDetails);
            } else {
                object = new Response(false, "No order with this id");
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    /*
    By idCustomer( the same sender )
     */
    @Override
    public Object queryAllOrderByIdCustomer(String id) {
        Object object = null;
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        String query = "SELECT B.name_shop_customer as name_shop_customer, B.number_customer as numberShop\n" +
                "\t, B.address_customer as addressShop , A.daytime_order as daytime_order\n" +
                "    , A.name_receiver_order as name_receiver_order, A.number_receiver_order as number_receiver_order\n" +
                "    , A.address_receiver_order as address_receiver_order, D.name_shipper as name_shipper\n" +
                "    , D.number_shipper as number_shipper, A.name_order as name_order\n" +
                "    , A.cost_order as cost_order, F.name_type as typeOrder\n" +
                "    , E.description_time as description_time, C.name_service as name_service\n" +
                "    , A.approve_order as approve_order, A.status_deliver_order as status_deliver_order, A.available_order as available_order\n" +
                "   FROM GHTK.orders as A INNER JOIN GHTK.customers as B ON A.id_shop_order = B.id_customer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.services as C ON A.id_service_order = C.id_service\n" +
                "                     INNER JOIN GHTK.shippers as D ON A.id_shipper_order = D.id_shipper\n" +
                "                     INNER JOIN GHTK.timeline as E ON A.id_time_order = E.id_time\n" +
                "                     INNER JOIN GHTK.types as F ON A.id_type_order = F.id_type" +
                "   WHERE A.id_shop_order = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("name_shop_customer"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daytime_order"),
                        resultSet.getString("name_receiver_order"),
                        resultSet.getString("number_receiver_order"),
                        resultSet.getString("address_receiver_order"),
                        resultSet.getString("name_shipper"),
                        resultSet.getString("number_shipper"),
                        resultSet.getString("name_order"),
                        resultSet.getInt("cost_order"),
                        resultSet.getString("name_type"),
                        resultSet.getString("description_time"),
                        resultSet.getString("name_service"),
                        resultSet.getBoolean("approve_order"),
                        resultSet.getBoolean("status_deliver_order"),
                        resultSet.getBoolean("available_order"));
                orderDetailsList.add(orderDetails);
            }
            object = new Response(true, orderDetailsList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    /*
    Same shipper
     */
    @Override
    public Object queryAllOrderByIdShipper(String id) {
        Object object = null;
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        String query = "SELECT B.name_shop_customer as name_shop_customer, B.number_customer as numberShop\n" +
                "\t, B.address_customer as addressShop , A.daytime_order as daytime_order\n" +
                "    , A.name_receiver_order as name_receiver_order, A.number_receiver_order as number_receiver_order\n" +
                "    , A.address_receiver_order as address_receiver_order, D.name_shipper as name_shipper\n" +
                "    , D.number_shipper as number_shipper, A.name_order as name_order\n" +
                "    , A.cost_order as cost_order, F.name_type as typeOrder\n" +
                "    , E.description_time as description_time, C.name_service as name_service\n" +
                "    , A.approve_order as approve_order, A.status_deliver_order as status_deliver_order, A.available_order as available_order\n" +
                "   FROM GHTK.orders as A INNER JOIN GHTK.customers as B ON A.id_shop_order = B.id_customer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.services as C ON A.id_service_order = C.id_service\n" +
                "                     INNER JOIN GHTK.shippers as D ON A.id_shipper_order = D.id_shipper\n" +
                "                     INNER JOIN GHTK.timeline as E ON A.id_time_order = E.id_time\n" +
                "                     INNER JOIN GHTK.types as F ON A.id_type_order = F.id_type" +
                "   WHERE A.id_shipper_order = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("name_shop_customer"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daytime_order"),
                        resultSet.getString("name_receiver_order"),
                        resultSet.getString("number_receiver_order"),
                        resultSet.getString("address_receiver_order"),
                        resultSet.getString("name_shipper"),
                        resultSet.getString("number_shipper"),
                        resultSet.getString("name_order"),
                        resultSet.getInt("cost_order"),
                        resultSet.getString("name_type"),
                        resultSet.getString("description_time"),
                        resultSet.getString("name_service"),
                        resultSet.getBoolean("approve_order"),
                        resultSet.getBoolean("status_deliver_order"),
                        resultSet.getBoolean("available_order"));
                orderDetailsList.add(orderDetails);
            }
            object = new Response(true, orderDetailsList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    /*
    See which orders have been approved or not
     */
    @Override
    public Object queryAllOrderNotApproved() {
        Object object = null;
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        String query = "SELECT B.name_shop_customer as name_shop_customer, B.number_customer as numberShop\n" +
                "\t, B.address_customer as addressShop , A.daytime_order as daytime_order\n" +
                "    , A.name_receiver_order as name_receiver_order, A.number_receiver_order as number_receiver_order\n" +
                "    , A.address_receiver_order as address_receiver_order, D.name_shipper as name_shipper\n" +
                "    , D.number_shipper as number_shipper, A.name_order as name_order\n" +
                "    , A.cost_order as cost_order, F.name_type as typeOrder\n" +
                "    , E.description_time as description_time, C.name_service as name_service\n" +
                "    , A.approve_order as approve_order, A.status_deliver_order as status_deliver_order, A.available_order as available_order\n" +
                "   FROM GHTK.orders as A INNER JOIN GHTK.customers as B ON A.id_shop_order = B.id_customer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.services as C ON A.id_service_order = C.id_service\n" +
                "                     INNER JOIN GHTK.shippers as D ON A.id_shipper_order = D.id_shipper\n" +
                "                     INNER JOIN GHTK.timeline as E ON A.id_time_order = E.id_time\n" +
                "                     INNER JOIN GHTK.types as F ON A.id_type_order = F.id_type" +
                "   WHERE A.approve_order = 0;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("name_shop_customer"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daytime_order"),
                        resultSet.getString("name_receiver_order"),
                        resultSet.getString("number_receiver_order"),
                        resultSet.getString("address_receiver_order"),
                        resultSet.getString("name_shipper"),
                        resultSet.getString("number_shipper"),
                        resultSet.getString("name_order"),
                        resultSet.getInt("cost_order"),
                        resultSet.getString("name_type"),
                        resultSet.getString("description_time"),
                        resultSet.getString("name_service"),
                        resultSet.getBoolean("approve_order"),
                        resultSet.getBoolean("status_deliver_order"),
                        resultSet.getBoolean("available_order"));
                orderDetailsList.add(orderDetails);
            }
            object = new Response(true, orderDetailsList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object queryAllOrderApproved() {
        Object object = null;
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        String query = "SELECT B.name_shop_customer as name_shop_customer, B.number_customer as numberShop\n" +
                "\t, B.address_customer as addressShop , A.daytime_order as daytime_order\n" +
                "    , A.name_receiver_order as name_receiver_order, A.number_receiver_order as number_receiver_order\n" +
                "    , A.address_receiver_order as address_receiver_order, D.name_shipper as name_shipper\n" +
                "    , D.number_shipper as number_shipper, A.name_order as name_order\n" +
                "    , A.cost_order as cost_order, F.name_type as typeOrder\n" +
                "    , E.description_time as description_time, C.name_service as name_service\n" +
                "    , A.approve_order as approve_order, A.status_deliver_order as status_deliver_order, A.available_order as available_order\n" +
                "   FROM GHTK.orders as A INNER JOIN GHTK.customers as B ON A.id_shop_order = B.id_customer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.services as C ON A.id_service_order = C.id_service\n" +
                "                     INNER JOIN GHTK.shippers as D ON A.id_shipper_order = D.id_shipper\n" +
                "                     INNER JOIN GHTK.timeline as E ON A.id_time_order = E.id_time\n" +
                "                     INNER JOIN GHTK.types as F ON A.id_type_order = F.id_type" +
                "   WHERE A.approve_order = 1;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("name_shop_customer"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daytime_order"),
                        resultSet.getString("name_receiver_order"),
                        resultSet.getString("number_receiver_order"),
                        resultSet.getString("address_receiver_order"),
                        resultSet.getString("name_shipper"),
                        resultSet.getString("number_shipper"),
                        resultSet.getString("name_order"),
                        resultSet.getInt("cost_order"),
                        resultSet.getString("name_type"),
                        resultSet.getString("description_time"),
                        resultSet.getString("name_service"),
                        resultSet.getBoolean("approve_order"),
                        resultSet.getBoolean("status_deliver_order"),
                        resultSet.getBoolean("available_order"));
                orderDetailsList.add(orderDetails);
            }
            object = new Response(true, orderDetailsList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    /*
    Admin approves all the order
     */
    @Override
    public Object approveAllOrder() {
        Object object = null;
        String update = "UPDATE GHTK.orders as A\n" +
                "SET A.approve_order = 1 \n" +
                "WHERE A.approve_order = 0;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            object = new Response(true, rowsEffected + " order(s) have been approved");
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object approveOneOrder(String id) {
        Object object = null;
        String update = "UPDATE GHTK.orders as A\n" +
                "SET A.approve_order = 1 \n" +
                "WHERE A.id_order = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected == 1){
                object = new Response(true, rowsEffected + " order(s) have been approved");
            } else {
                object = new Response(false, "No order with this id");
            }

        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object registerCustomer(Customer customer) throws SQLException {
        Object object = null;
        if (customer == null) {
            object = new Response(false, "We dont accept null information here");
        }

        String insert = "INSERT INTO GHTK.customers(id_customer,name_customer,name_shop_customer" +
                                                    ",area_customer,number_customer" +
                                                    ",address_customer,mail_customer,taxcode_customer) VALUES (?,?,?,?,?,?,?,?)";

        String lastRecord = "SELECT id_customer FROM GHTK.customers ORDER BY id_customer DESC LIMIT 1;";
        PreparedStatement lastRecordPS = connection.prepareStatement(lastRecord);
        ResultSet resultLastRecord = lastRecordPS.executeQuery();

        String checkMail = "SELECT mail_customer FROM GHTK.customers WHERE mail_customer = '" + customer.getMailCustomer() + "';";
        PreparedStatement mail = connection.prepareStatement(checkMail);
        ResultSet resultMail = mail.executeQuery();
        String checkNumber = "SELECT number_customer FROM GHTK.customers WHERE number_customer = '" + customer.getNumberCustomer() + "';";
        PreparedStatement number = connection.prepareStatement(checkNumber);
        ResultSet resultNumber = number.executeQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            if (resultMail.next()) {
                object = new Response(false, "This mail has already been in use");
            } else if (resultNumber.next()) {
                object = new Response(false, "This number has already been in use");
            } else if (!ValidateMail.validate(customer.getMailCustomer())){
                object = new Response(false, "Email is invalid");
            } else {
                if (resultLastRecord.next()) {
                    String tempId = resultLastRecord.getString(1).replaceAll("[a-zA-Z]+", "");
                    Integer num = Integer.parseInt(tempId) + 1;

                    preparedStatement.setString(1, "KH" + num);
                } else {
                    preparedStatement.setString(1, "KH1");
                }
                preparedStatement.setString(2, customer.getNameCustomer());
                preparedStatement.setString(3, customer.getNameShop());
                preparedStatement.setString(4, customer.getAreaCustomer());
                preparedStatement.setString(5, customer.getNumberCustomer());
                preparedStatement.setString(6, customer.getAddressCustomer());
                preparedStatement.setString(7, customer.getMailCustomer());
                preparedStatement.setString(8, customer.getTaxCodeCustomer());
                preparedStatement.executeUpdate();
                object = new Response(true, customer);
            }
        } catch (Exception e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object registerShipper(Shipper shipper) throws SQLException {
        Object object = null;
        if (shipper == null) {
            object = new Response(false, "We dont accept null information here");
        }

        String insert = "INSERT INTO GHTK.shippers(id_shipper,name_shipper,born_shipper" +
                                                ",gender_shipper,number_shipper" +
                                                ",address_shipper,mail_shipper) VALUES (?,?,?,?,?,?,?)";

        String lastRecord = "SELECT id_shipper FROM GHTK.shippers ORDER BY id_shipper DESC LIMIT 1;";
        PreparedStatement lastRecordPS = connection.prepareStatement(lastRecord);
        ResultSet resultLastRecord = lastRecordPS.executeQuery();

        String checkMail = "SELECT mail_shipper FROM GHTK.shippers WHERE mail_shipper = '" + shipper.getMailShipper() + "';";
        String checkNumber = "SELECT number_shipper FROM GHTK.shippers WHERE number_shipper = '" + shipper.getNumberShipper() + "';";

        PreparedStatement mail = connection.prepareStatement(checkMail);
        PreparedStatement number = connection.prepareStatement(checkNumber);

        ResultSet resultMail = mail.executeQuery();
        ResultSet resultNumber = number.executeQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            if (resultMail.next()) {
                object = new Response(false, "This mail has already been in use");
            } else if (resultNumber.next()) {
                object = new Response(false, "This number has already been in use");
            } else if (!ValidateMail.validate(shipper.getMailShipper())){
                object = new Response(false, "Email is invalid");
            } else {
                if (resultLastRecord.next()) {
                    String tempId = resultLastRecord.getString(1).replaceAll("[a-zA-Z]+", "");
                    Integer num = Integer.parseInt(tempId) + 1;

                    preparedStatement.setString(1, "TV" + num);
                } else {
                    preparedStatement.setString(1, "TV1");
                }
                preparedStatement.setString(2, shipper.getNameShipper());
                preparedStatement.setString(3, shipper.getBornShipper());
                preparedStatement.setBoolean(4, shipper.isGenderShipper());
                preparedStatement.setString(5, shipper.getNumberShipper());
                preparedStatement.setString(6, shipper.getAddressShipper());
                preparedStatement.setString(7, shipper.getMailShipper());
                preparedStatement.executeUpdate();
                object = new Response(true, shipper);
            }
        } catch (Exception e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

}

