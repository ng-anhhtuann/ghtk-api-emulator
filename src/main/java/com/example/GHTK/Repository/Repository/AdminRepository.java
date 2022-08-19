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
        String timeCreated = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        String insert = "INSERT INTO GHTK.Area(idArea,nameArea,timeCreated) VALUES (?,?,?)";

        String lastRecord = "SELECT idArea FROM GHTK.Area ORDER BY idArea DESC LIMIT 1;";
        PreparedStatement lastRecordPS = connection.prepareStatement(lastRecord);
        ResultSet resultLastRecord = lastRecordPS.executeQuery();

        String check = "SELECT nameArea FROM GHTK.Area WHERE nameArea = '" + area.getNameArea() + "';";
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
                preparedStatement.setString(3, timeCreated);
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
        String timeCreated = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        String insert = "INSERT INTO GHTK.Service(idService,nameService,timeCreated) VALUES (?,?,?)";

        String lastRecord = "SELECT idService FROM GHTK.Service ORDER BY idService DESC LIMIT 1;";
        PreparedStatement lastRecordPS = connection.prepareStatement(lastRecord);
        ResultSet resultLastRecord = lastRecordPS.executeQuery();

        String check = "SELECT nameService FROM GHTK.Service WHERE nameService = '" + service.getNameService() + "';";
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
                preparedStatement.setString(2, service.getNameService());
                preparedStatement.setString(3, timeCreated);
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
        String timeCreated = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        String insert = "INSERT INTO GHTK.Time(idTime,descriptionTime,timeCreated) VALUES (?,?,?)";

        String lastRecord = "SELECT idTime FROM GHTK.Time ORDER BY idTime DESC LIMIT 1;";
        PreparedStatement lastRecordPS = connection.prepareStatement(lastRecord);
        ResultSet resultLastRecord = lastRecordPS.executeQuery();

        String check = "SELECT descriptionTime FROM GHTK.Time WHERE descriptionTime = '" + timeLine.getDescription() + "';";
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
                preparedStatement.setString(2, timeLine.getDescription());
                preparedStatement.setString(3, timeCreated);
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
        String timeCreated = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        String insert = "INSERT INTO GHTK.Type(idType,nameType,timeCreated) VALUES (?,?,?)";

        String lastRecord = "SELECT idType FROM GHTK.Type ORDER BY idType DESC LIMIT 1;";
        PreparedStatement lastRecordPS = connection.prepareStatement(lastRecord);
        ResultSet resultLastRecord = lastRecordPS.executeQuery();

        String check = "SELECT nameType FROM GHTK.Type WHERE nameType = '" + type.getNameProduct() + "';";
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
                preparedStatement.setString(2, type.getNameProduct());
                preparedStatement.setString(3, timeCreated);
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

        String query = "SELECT * FROM GHTK.Area;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                Area area = new Area(resultSet.getString("nameArea"));
                areaList.add(area);
            }
            object = new Response(true, areaList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object queryAreaById(String idArea) {
        Object object = null;
        Area area = null;
        String query = "SELECT * FROM GHTK.Area WHERE idArea ='" + idArea + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()) {
                area = new Area(resultSet.getString("nameArea"));
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

        String query = "SELECT * FROM GHTK.Time;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                TimeLine time = new TimeLine(resultSet.getString("descriptionTime"));
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
        String query = "SELECT * FROM GHTK.Time WHERE idTime ='" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()) {
                timeLine = new TimeLine(resultSet.getString("descriptionTime"));
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

        String query = "SELECT * FROM GHTK.Service;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                Service service = new Service(resultSet.getString("nameService"));
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
        String query = "SELECT * FROM GHTK.Service WHERE idService ='" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()) {
                service = new Service(resultSet.getString("nameService"));
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

        String query = "SELECT * FROM GHTK.Type;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                Type type = new Type(resultSet.getString("nameType"));
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
        String query = "SELECT * FROM GHTK.Type WHERE idType ='" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()) {
                type = new Type(resultSet.getString("nameType"));
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

        String query = "SELECT * FROM GHTK.Customer;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                Customer customer = new Customer(resultSet.getString("idCustomer"),
                        resultSet.getString("nameCustomer"),
                        resultSet.getString("nameShop"),
                        resultSet.getString("areaCustomer"),
                        resultSet.getString("numberCustomer"),
                        resultSet.getString("addressCustomer"),
                        resultSet.getString("mailCustomer"),
                        resultSet.getString("taxCodeCustomer"));
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
        String query = "SELECT * FROM GHTK.Customer WHERE idCustomer ='" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()) {
                customer = new Customer(resultSet.getString("idCustomer"),
                        resultSet.getString("nameCustomer"),
                        resultSet.getString("nameShop"),
                        resultSet.getString("areaCustomer"),
                        resultSet.getString("numberCustomer"),
                        resultSet.getString("addressCustomer"),
                        resultSet.getString("mailCustomer"),
                        resultSet.getString("taxCodeCustomer"));
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

        String query = "SELECT * FROM GHTK.Shipper;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                Shipper shipper = new Shipper(resultSet.getString("idShipper"),
                        resultSet.getString("nameShipper"),
                        resultSet.getString("bornShipper"),
                        resultSet.getBoolean("genderShipper"),
                        resultSet.getString("numberShipper"),
                        resultSet.getString("addressShipper"),
                        resultSet.getString("mailShipper"));
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
        String query = "SELECT * FROM GHTK.Shipper WHERE idShipper ='" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()) {
                shipper = new Shipper(resultSet.getString("idShipper"),
                        resultSet.getString("nameShipper"),
                        resultSet.getString("bornShipper"),
                        resultSet.getBoolean("genderShipper"),
                        resultSet.getString("numberShipper"),
                        resultSet.getString("addressShipper"),
                        resultSet.getString("mailShipper"));
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

        String query = "SELECT B.nameShop as nameShop, B.numberCustomer as numberShop\n" +
                "\t, B.addressCustomer as addressShop , A.daysendOrder as daysendOrder\n" +
                "    , A.nameReceiver as nameReceiver, A.numberReceiver as numberReceiver\n" +
                "    , A.addressReceiver as addressReceiver, D.nameShipper as nameShipper\n" +
                "    , D.numberShipper as numberShipper, A.nameOrder as nameOrder\n" +
                "    , A.costOrder as costOrder, F.nameType as typeOrder\n" +
                "    , E.descriptionTime as descriptionTime, C.nameService as nameService\n" +
                "    , A.approveOrder as approveOrder, A.statusDeliver as statusDeliver, A.isAvailable as isAvailable\n" +
                "   FROM GHTK.Order as A INNER JOIN GHTK.Customer as B ON A.idshopOrder = B.idCustomer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.Service as C ON A.idserviceOrder = C.idService\n" +
                "                     INNER JOIN GHTK.Shipper as D ON A.idshipperOrder = D.idShipper\n" +
                "                     INNER JOIN GHTK.Time as E ON A.idtimeOrder = E.idTime\n" +
                "                     INNER JOIN GHTK.Type as F ON A.idtypeOrder = F.idType;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("nameShop"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daysendOrder"),
                        resultSet.getString("nameReceiver"),
                        resultSet.getString("numberReceiver"),
                        resultSet.getString("addressReceiver"),
                        resultSet.getString("nameShipper"),
                        resultSet.getString("numberShipper"),
                        resultSet.getString("nameOrder"),
                        resultSet.getInt("costOrder"),
                        resultSet.getString("nameType"),
                        resultSet.getString("descriptionTime"),
                        resultSet.getString("nameService"),
                        resultSet.getBoolean("approveOrder"),
                        resultSet.getBoolean("statusDeliver"),
                        resultSet.getBoolean("isAvailable"));
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

        String query = "SELECT B.nameShop as nameShop, B.numberCustomer as numberShop\n" +
                "\t, B.addressCustomer as addressShop , A.daysendOrder as daysendOrder\n" +
                "    , A.nameReceiver as nameReceiver, A.numberReceiver as numberReceiver\n" +
                "    , A.addressReceiver as addressReceiver, D.nameShipper as nameShipper\n" +
                "    , D.numberShipper as numberShipper, A.nameOrder as nameOrder\n" +
                "    , A.costOrder as costOrder, F.nameType as typeOrder\n" +
                "    , E.descriptionTime as descriptionTime, C.nameService as nameService\n" +
                "    , A.approveOrder as approveOrder, A.statusDeliver as statusDeliver, A.isAvailable as isAvailable\n" +
                "   FROM GHTK.Order as A INNER JOIN GHTK.Customer as B ON A.idshopOrder = B.idCustomer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.Service as C ON A.idserviceOrder = C.idService\n" +
                "                     INNER JOIN GHTK.Shipper as D ON A.idshipperOrder = D.idShipper\n" +
                "                     INNER JOIN GHTK.Time as E ON A.idtimeOrder = E.idTime\n" +
                "                     INNER JOIN GHTK.Type as F ON A.idtypeOrder = F.idType" +
                "   WHERE A.idOrder = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()) {
                orderDetails = new OrderDetails(resultSet.getString("nameShop"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daysendOrder"),
                        resultSet.getString("nameReceiver"),
                        resultSet.getString("numberReceiver"),
                        resultSet.getString("addressReceiver"),
                        resultSet.getString("nameShipper"),
                        resultSet.getString("numberShipper"),
                        resultSet.getString("nameOrder"),
                        resultSet.getInt("costOrder"),
                        resultSet.getString("nameType"),
                        resultSet.getString("descriptionTime"),
                        resultSet.getString("nameService"),
                        resultSet.getBoolean("approveOrder"),
                        resultSet.getBoolean("statusDeliver"),
                        resultSet.getBoolean("isAvailable"));
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

        String query = "SELECT B.nameShop as nameShop, B.numberCustomer as numberShop\n" +
                "\t, B.addressCustomer as addressShop , A.daysendOrder as daysendOrder\n" +
                "    , A.nameReceiver as nameReceiver, A.numberReceiver as numberReceiver\n" +
                "    , A.addressReceiver as addressReceiver, D.nameShipper as nameShipper\n" +
                "    , D.numberShipper as numberShipper, A.nameOrder as nameOrder\n" +
                "    , A.costOrder as costOrder, F.nameType as typeOrder\n" +
                "    , E.descriptionTime as descriptionTime, C.nameService as nameService\n" +
                "    , A.approveOrder as approveOrder, A.statusDeliver as statusDeliver, A.isAvailable as isAvailable\n" +
                "   FROM GHTK.Order as A INNER JOIN GHTK.Customer as B ON A.idshopOrder = B.idCustomer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.Service as C ON A.idserviceOrder = C.idService\n" +
                "                     INNER JOIN GHTK.Shipper as D ON A.idshipperOrder = D.idShipper\n" +
                "                     INNER JOIN GHTK.Time as E ON A.idtimeOrder = E.idTime\n" +
                "                     INNER JOIN GHTK.Type as F ON A.idtypeOrder = F.idType" +
                "   WHERE A.idshopOrder = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("nameShop"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daysendOrder"),
                        resultSet.getString("nameReceiver"),
                        resultSet.getString("numberReceiver"),
                        resultSet.getString("addressReceiver"),
                        resultSet.getString("nameShipper"),
                        resultSet.getString("numberShipper"),
                        resultSet.getString("nameOrder"),
                        resultSet.getInt("costOrder"),
                        resultSet.getString("nameType"),
                        resultSet.getString("descriptionTime"),
                        resultSet.getString("nameService"),
                        resultSet.getBoolean("approveOrder"),
                        resultSet.getBoolean("statusDeliver"),
                        resultSet.getBoolean("isAvailable"));
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

        String query = "SELECT B.nameShop as nameShop, B.numberCustomer as numberShop\n" +
                "\t, B.addressCustomer as addressShop , A.daysendOrder as daysendOrder\n" +
                "    , A.nameReceiver as nameReceiver, A.numberReceiver as numberReceiver\n" +
                "    , A.addressReceiver as addressReceiver, D.nameShipper as nameShipper\n" +
                "    , D.numberShipper as numberShipper, A.nameOrder as nameOrder\n" +
                "    , A.costOrder as costOrder, F.nameType as typeOrder\n" +
                "    , E.descriptionTime as descriptionTime, C.nameService as nameService\n" +
                "    , A.approveOrder as approveOrder, A.statusDeliver as statusDeliver, A.isAvailable as isAvailable\n" +
                "   FROM GHTK.Order as A INNER JOIN GHTK.Customer as B ON A.idshopOrder = B.idCustomer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.Service as C ON A.idserviceOrder = C.idService\n" +
                "                     INNER JOIN GHTK.Shipper as D ON A.idshipperOrder = D.idShipper\n" +
                "                     INNER JOIN GHTK.Time as E ON A.idtimeOrder = E.idTime\n" +
                "                     INNER JOIN GHTK.Type as F ON A.idtypeOrder = F.idType" +
                "   WHERE A.idshipperOrder = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("nameShop"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daysendOrder"),
                        resultSet.getString("nameReceiver"),
                        resultSet.getString("numberReceiver"),
                        resultSet.getString("addressReceiver"),
                        resultSet.getString("nameShipper"),
                        resultSet.getString("numberShipper"),
                        resultSet.getString("nameOrder"),
                        resultSet.getInt("costOrder"),
                        resultSet.getString("nameType"),
                        resultSet.getString("descriptionTime"),
                        resultSet.getString("nameService"),
                        resultSet.getBoolean("approveOrder"),
                        resultSet.getBoolean("statusDeliver"),
                        resultSet.getBoolean("isAvailable"));
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

        String query = "SELECT B.nameShop as nameShop, B.numberCustomer as numberShop\n" +
                "\t, B.addressCustomer as addressShop , A.daysendOrder as daysendOrder\n" +
                "    , A.nameReceiver as nameReceiver, A.numberReceiver as numberReceiver\n" +
                "    , A.addressReceiver as addressReceiver, D.nameShipper as nameShipper\n" +
                "    , D.numberShipper as numberShipper, A.nameOrder as nameOrder\n" +
                "    , A.costOrder as costOrder, F.nameType as typeOrder\n" +
                "    , E.descriptionTime as descriptionTime, C.nameService as nameService\n" +
                "    , A.approveOrder as approveOrder, A.statusDeliver as statusDeliver, A.isAvailable as isAvailable\n" +
                "   FROM GHTK.Order as A INNER JOIN GHTK.Customer as B ON A.idshopOrder = B.idCustomer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.Service as C ON A.idserviceOrder = C.idService\n" +
                "                     INNER JOIN GHTK.Shipper as D ON A.idshipperOrder = D.idShipper\n" +
                "                     INNER JOIN GHTK.Time as E ON A.idtimeOrder = E.idTime\n" +
                "                     INNER JOIN GHTK.Type as F ON A.idtypeOrder = F.idType" +
                "   WHERE A.approveOrder = 0;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("nameShop"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daysendOrder"),
                        resultSet.getString("nameReceiver"),
                        resultSet.getString("numberReceiver"),
                        resultSet.getString("addressReceiver"),
                        resultSet.getString("nameShipper"),
                        resultSet.getString("numberShipper"),
                        resultSet.getString("nameOrder"),
                        resultSet.getInt("costOrder"),
                        resultSet.getString("nameType"),
                        resultSet.getString("descriptionTime"),
                        resultSet.getString("nameService"),
                        resultSet.getBoolean("approveOrder"),
                        resultSet.getBoolean("statusDeliver"),
                        resultSet.getBoolean("isAvailable"));
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

        String query = "SELECT B.nameShop as nameShop, B.numberCustomer as numberShop\n" +
                "\t, B.addressCustomer as addressShop , A.daysendOrder as daysendOrder\n" +
                "    , A.nameReceiver as nameReceiver, A.numberReceiver as numberReceiver\n" +
                "    , A.addressReceiver as addressReceiver, D.nameShipper as nameShipper\n" +
                "    , D.numberShipper as numberShipper, A.nameOrder as nameOrder\n" +
                "    , A.costOrder as costOrder, F.nameType as typeOrder\n" +
                "    , E.descriptionTime as descriptionTime, C.nameService as nameService\n" +
                "    , A.approveOrder as approveOrder, A.statusDeliver as statusDeliver, A.isAvailable as isAvailable\n" +
                "   FROM GHTK.Order as A INNER JOIN GHTK.Customer as B ON A.idshopOrder = B.idCustomer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.Service as C ON A.idserviceOrder = C.idService\n" +
                "                     INNER JOIN GHTK.Shipper as D ON A.idshipperOrder = D.idShipper\n" +
                "                     INNER JOIN GHTK.Time as E ON A.idtimeOrder = E.idTime\n" +
                "                     INNER JOIN GHTK.Type as F ON A.idtypeOrder = F.idType" +
                "   WHERE A.approveOrder = 1;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("nameShop"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daysendOrder"),
                        resultSet.getString("nameReceiver"),
                        resultSet.getString("numberReceiver"),
                        resultSet.getString("addressReceiver"),
                        resultSet.getString("nameShipper"),
                        resultSet.getString("numberShipper"),
                        resultSet.getString("nameOrder"),
                        resultSet.getInt("costOrder"),
                        resultSet.getString("nameType"),
                        resultSet.getString("descriptionTime"),
                        resultSet.getString("nameService"),
                        resultSet.getBoolean("approveOrder"),
                        resultSet.getBoolean("statusDeliver"),
                        resultSet.getBoolean("isAvailable"));
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
        String update = "UPDATE GHTK.Order as A\n" +
                "SET A.approveOrder = 1 \n" +
                "WHERE A.approveOrder = 0;";
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
        String update = "UPDATE GHTK.Order as A\n" +
                "SET A.approveOrder = 1 \n" +
                "WHERE A.idOrder = '" + id + "';";
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
    public Object registerCustomer(Customer customer) throws SQLException {
        Object object = null;
        if (customer == null) {
            object = new Response(false, "We dont accept null information here");
        }

        String insert = "INSERT INTO GHTK.Customer(idCustomer,nameCustomer,nameShop,areaCustomer,numberCustomer,addressCustomer,mailCustomer,taxCodeCustomer) VALUES (?,?,?,?,?,?,?,?)";

        String lastRecord = "SELECT idCustomer FROM GHTK.Customer ORDER BY idCustomer DESC LIMIT 1;";
        PreparedStatement lastRecordPS = connection.prepareStatement(lastRecord);
        ResultSet resultLastRecord = lastRecordPS.executeQuery();

        String checkMail = "SELECT mailCustomer FROM GHTK.Customer WHERE mailCustomer = '" + customer.getMailCustomer() + "';";
        PreparedStatement mail = connection.prepareStatement(checkMail);
        ResultSet resultMail = mail.executeQuery();
        String checkNumber = "SELECT numberCustomer FROM GHTK.Customer WHERE numberCustomer = '" + customer.getNumberCustomer() + "';";
        PreparedStatement number = connection.prepareStatement(checkNumber);
        ResultSet resultNumber = number.executeQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            if (resultMail.next()) {
                object = new Response(false, "This mail has already been in use");
            } else if (resultNumber.next()) {
                object = new Response(false, "This number has already been in use");
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

        String insert = "INSERT INTO GHTK.Shipper(idShipper,nameShipper,bornShipper,genderShipper,numberShipper,addressShipper,mailShipper) VALUES (?,?,?,?,?,?,?)";

        String lastRecord = "SELECT idShipper FROM GHTK.Shipper ORDER BY idShipper DESC LIMIT 1;";
        PreparedStatement lastRecordPS = connection.prepareStatement(lastRecord);
        ResultSet resultLastRecord = lastRecordPS.executeQuery();

        String checkMail = "SELECT mailShipper FROM GHTK.Shipper WHERE mailShipper = '" + shipper.getMailShipper() + "';";
        String checkNumber = "SELECT numberShipper FROM GHTK.Shipper WHERE numberShipper = '" + shipper.getNumberShipper() + "';";

        PreparedStatement mail = connection.prepareStatement(checkMail);
        PreparedStatement number = connection.prepareStatement(checkNumber);

        ResultSet resultMail = mail.executeQuery();
        ResultSet resultNumber = number.executeQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            if (resultMail.next()) {
                object = new Response(false, "This mail has already been in use");
            } else if (resultNumber.next()) {
                object = new Response(false, "This number has already been in use");
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

