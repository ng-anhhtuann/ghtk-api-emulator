package com.example.GHTK.Repository;

import com.example.GHTK.Model.AdminRight.Service;
import com.example.GHTK.Model.AdminRight.TimeLine;
import com.example.GHTK.Model.AdminRight.Type;
import com.example.GHTK.Model.Custom.OrderDetails;
import com.example.GHTK.Model.Status.Error;
import com.example.GHTK.Model.Status.Success;
import com.example.GHTK.Model.AdminRight.Area;
import com.example.GHTK.Model.UserRight.Customer;
import com.example.GHTK.Model.UserRight.Order;
import com.example.GHTK.Model.UserRight.Shipper;
import com.example.GHTK.Ultilities.Database;
import com.example.GHTK.Ultilities.ValidateMail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.util.List;

public class Repository implements RepoManager {
    private static final Database database = Database.getDatabase();
    private static final Connection connection = database.getConnection();

    public static Repository repository;

    public static Repository getRepository() {
        if (repository == null) {
            repository = new Repository();
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
            object = new Error(false, "We dont accept null information here");
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
                object = new Error(false, "Duplicated value in database");
            } else {
                if (resultLastRecord.next()) {
                    String tempId = resultLastRecord.getString(1).replaceAll("[a-zA-Z]+", "");
                    Integer num = Integer.parseInt(tempId) + 1;

                    preparedStatement.setString(1, "KV" + num);
                    preparedStatement.setString(2, area.getNameArea());
                    preparedStatement.setString(3, timeCreated);
                    preparedStatement.executeUpdate();
                } else {
                    preparedStatement.setString(1, "KV1");
                    preparedStatement.setString(2, area.getNameArea());
                    preparedStatement.setString(3, timeCreated);
                    preparedStatement.executeUpdate();
                }
                object = new Success(true, area.toString());
            }
        } catch (Exception e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object insert(Service service) throws SQLException {
        Object object = null;
        if (service == null) {
            object = new Error(false, "We dont accept null information here");
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
                object = new Error(false, "Duplicated value in database");
            } else {
                if (resultLastRecord.next()) {
                    String tempId = resultLastRecord.getString(1).replaceAll("[a-zA-Z]+", "");
                    Integer num = Integer.parseInt(tempId) + 1;

                    preparedStatement.setString(1, "KV" + num);
                    preparedStatement.setString(2, service.getNameService());
                    preparedStatement.setString(3, timeCreated);
                    preparedStatement.executeUpdate();
                } else {
                    preparedStatement.setString(1, "KV1");
                    preparedStatement.setString(2, service.getNameService());
                    preparedStatement.setString(3, timeCreated);
                    preparedStatement.executeUpdate();
                }
                object = new Success(true, service.toString());
            }
        } catch (Exception e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object insert(TimeLine timeLine) throws SQLException {
        Object object = null;
        if (timeLine == null) {
            object = new Error(false, "We dont accept null information here");
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
                object = new Error(false, "Duplicated value in database");
            } else {
                if (resultLastRecord.next()) {
                    String tempId = resultLastRecord.getString(1).replaceAll("[a-zA-Z]+", "");
                    Integer num = Integer.parseInt(tempId) + 1;

                    preparedStatement.setString(1, "KV" + num);
                    preparedStatement.setString(2, timeLine.getDescription());
                    preparedStatement.setString(3, timeCreated);
                    preparedStatement.executeUpdate();
                } else {
                    preparedStatement.setString(1, "KV1");
                    preparedStatement.setString(2, timeLine.getDescription());
                    preparedStatement.setString(3, timeCreated);
                    preparedStatement.executeUpdate();
                }
                object = new Success(true, timeLine.toString());
            }
        } catch (Exception e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object insert(Type type) throws SQLException {
        Object object = null;
        if (type == null) {
            object = new Error(false, "We dont accept null information here");
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
                object = new Error(false, "Duplicated value in database");
            } else {
                if (resultLastRecord.next()) {
                    String tempId = resultLastRecord.getString(1).replaceAll("[a-zA-Z]+", "");
                    Integer num = Integer.parseInt(tempId) + 1;

                    preparedStatement.setString(1, "KV" + num);
                    preparedStatement.setString(2, type.getNameProduct());
                    preparedStatement.setString(3, timeCreated);
                    preparedStatement.executeUpdate();
                } else {
                    preparedStatement.setString(1, "KV1");
                    preparedStatement.setString(2, type.getNameProduct());
                    preparedStatement.setString(3, timeCreated);
                    preparedStatement.executeUpdate();
                }
                object = new Success(true, type.toString());
            }
        } catch (Exception e) {
            object = new Error(false, e.getMessage());
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
            object = new Success(true, areaList.toString());
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
                object = new Success(true, area.toString());
            } else {
                object = new Error(false, "No area with this id");
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
            object = new Success(true, timeList.toString());
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
                object = new Success(true, timeLine.toString());
            } else {
                object = new Error(false, "No time with this id");
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
            object = new Success(true, serviceList.toString());
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
                object = new Success(true, service.toString());
            } else {
                object = new Error(false, "No service with this id");
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
            object = new Success(true, typeList.toString());
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
                object = new Success(true, type.toString());
            } else {
                object = new Error(false, "No type with this id");
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
            object = new Success(true, customerList.toString());
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
                object = new Success(true, customer.toString());
            } else {
                object = new Error(false, "No customer with this id");
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
            object = new Success(true, shipperList.toString());
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
                object = new Success(true, shipper.toString());
            } else {
                object = new Error(false, "No shipper with this id");
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
            object = new Success(true, orderDetailsList.toString());
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    /*
    By idOrder
     */
    @Override
    public Object queryOrderByIdOrder(String idOrder) {
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
                "   WHERE A.idOrder = '" + idOrder + "';";
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
                object = new Success(true, orderDetails.toString());
            } else {
                object = new Error(false, "No order with this id");
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    /*
    By idCustomer( the same sender )
     */
    @Override
    public Object queryAllOrderByIdCustomer(String idshopOrder) {
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
                "   WHERE A.idshopOrder = '" + idshopOrder + "';";
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
            object = new Success(true, orderDetailsList.toString());
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
            object = new Success(true, orderDetailsList.toString());
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
            object = new Success(true, orderDetailsList.toString());
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
            object = new Success(true, orderDetailsList.toString());
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
            object = new Success(true, rowsEffected + " order(s) have been approved");
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
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
            object = new Success(true, rowsEffected + " order(s) have been approved");
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    /*
    UserRight API (Shipper and Customer)
     */

    /*
    Shop abilities
     */
    @Override
    public Object createOrder(Order order) throws SQLException {
        Object object = null;
        if (order == null) {
            object = new Error(false, "We dont accept null information here");
        }

        String insert = "INSERT INTO GHTK.Order(idOrder, idshopOrder, idshipperOrder, idserviceOrder," +
                "idtypeOrder, idtimeOrder, daysendOrder, nameOrder, weightOrder, costOrder," +
                "nameReceiver, numberReceiver, addressReceiver, paymentOrder, approveOrder," +
                "statusDeliver, isAvailable) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String timeCreated = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        String lastRecord = "SELECT idOrder FROM GHTK.Order ORDER BY idOrder DESC LIMIT 1;";
        PreparedStatement lastRecordPS = connection.prepareStatement(lastRecord);
        ResultSet resultLastRecord = lastRecordPS.executeQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            if (resultLastRecord.next()) {
                String tempId = resultLastRecord.getString(1).replaceAll("[a-zA-Z]+", "");
                Integer num = Integer.parseInt(tempId) + 1;

                preparedStatement.setString(1, "DH" + num);
            } else {
                preparedStatement.setString(1, "DH1");
            }
            preparedStatement.setString(2, order.getIdshopOrder());
            preparedStatement.setString(3, null);
            preparedStatement.setString(4, order.getIdserviceOrder());
            preparedStatement.setString(5, order.getIdtypeOrder());
            preparedStatement.setString(6, order.getIdtimeOrder());
            preparedStatement.setString(7, timeCreated);
            preparedStatement.setString(8, order.getNameOrder());
            preparedStatement.setDouble(9, order.getWeightOrder());
            preparedStatement.setInt(10, order.getCostOrder());
            preparedStatement.setString(11, order.getNameReceiver());
            preparedStatement.setString(12, order.getNumberReceiver());
            preparedStatement.setString(13, order.getAddressReceiver());
            preparedStatement.setBoolean(14, order.isPaymentOrder());
            preparedStatement.setBoolean(15, false);
            preparedStatement.setBoolean(16, false);
            preparedStatement.setBoolean(17, true);
            preparedStatement.executeUpdate();
            object = new Success(true, order.toString());
        } catch (Exception e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    /*
    Editable details in Customer by Customer
     */
    @Override
    public Object updateAddressCustomer(String id, String newAddress) {
        Object object = null;
        String update = "UPDATE GHTK.Customer as A\n" +
                "SET A.addressCustomer = '" + newAddress + "' \n" +
                "WHERE A.idCustomer = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Success(true, "Address is updated for user " + id);
            } else {
                object = new Error(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateNameShopCustomer(String id, String newNameShop) {
        Object object = null;
        String update = "UPDATE GHTK.Customer as A\n" +
                "SET A.nameShop = '" + newNameShop + "' \n" +
                "WHERE A.idCustomer = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Success(true, "NameShop is updated for user " + id);
            } else {
                object = new Error(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateNameCustomer(String id, String newNameCustomer) {
        Object object = null;
        String update = "UPDATE GHTK.Customer as A\n" +
                "SET A.nameCustomer = '" + newNameCustomer + "' \n" +
                "WHERE A.idCustomer = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Success(true, "Name Customer is updated for user " + id);
            } else {
                object = new Error(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateAreaCustomer(String id, String newArea) {
        Object object = null;
        String update = "UPDATE GHTK.Customer as A\n" +
                "SET A.areaCustomer = '" + newArea + "' \n" +
                "WHERE A.idCustomer = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Success(true, "Area is updated for user " + id);
            } else {
                object = new Error(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateNumberCustomer(String id, String newNumber) {
        Object object = null;
        String update = "UPDATE GHTK.Customer as A\n" +
                "SET A.numberCustomer = '" + newNumber + "' \n" +
                "WHERE A.idCustomer = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Success(true, "Number is updated for user " + id);
            } else {
                object = new Error(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateMailCustomer(String id, String newMail) {
        Object object = null;

        String update = "UPDATE GHTK.Customer as A\n" +
                "SET A.mailCustomer = '" + newMail + "' \n" +
                "WHERE A.idCustomer = '" + id + "';";

        if (ValidateMail.validate(newMail)) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(update);
                int rowsEffected = preparedStatement.executeUpdate();
                if (rowsEffected != 0) {
                    object = new Success(true, "Mail is updated for user " + id);
                } else {
                    object = new Error(false, "Unknown id :" + id);
                }
            } catch (SQLException e) {
                object = new Error(false, e.getMessage());
            }
        } else {
            object = new Error(false, "Invalid mail format!");
        }

        return object;
    }


    /*
    Shipper abilities
     */
    @Override
    public Object queryAllOrderAvailable() {
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
                "   WHERE A.isAvailable = 1;";
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
            object = new Success(true, orderDetailsList.toString());
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object registerOrder(String idOrder, String idShipper) {
        Object object = null;
        String checkAvailable = "SELECT isAvailable FROM GHTK.Order WHERE idOrder = '" + idOrder + "';";
        String register = "UPDATE GHTK.Order as A\n" +
                "SET A.idshipperOrder = '" + idShipper + "' \n" +
                "WHERE A.idOrder = '" + idOrder + "';";

        try {
            PreparedStatement checkStatement = connection.prepareStatement(checkAvailable);
            ResultSet set = checkStatement.executeQuery();
            int isAvailable = set.getInt(1);
            if (isAvailable == 1) {
                PreparedStatement takeStatement = connection.prepareStatement(register);
                int row = takeStatement.executeUpdate();
                if (row != 0) {
                    object = new Success(true, "Order: " + idOrder + "is taken by shipper: " + idShipper);
                } else {
                    object = new Error(false, "No order with id: " + idOrder);
                }
            } else {
                object = new Error(false, "Order: " + idOrder + " was taken before :(");
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
        }

        return object;
    }

    @Override
    public Object updateAddressShipper(String id, String newAddress) {
        Object object = null;
        String update = "UPDATE GHTK.Shipper as A\n" +
                "SET A.addressShipper = '" + newAddress + "' \n" +
                "WHERE A.idShipper = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Success(true, "Address is updated for user " + id);
            } else {
                object = new Error(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateNameShipper(String id, String newNameShipper) {
        Object object = null;
        String update = "UPDATE GHTK.Shipper as A\n" +
                "SET A.nameShipper = '" + newNameShipper + "' \n" +
                "WHERE A.idShipper = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Success(true, "Name Shipper is updated for user " + id);
            } else {
                object = new Error(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateNumberShipper(String id, String newNumber) {
        Object object = null;
        String update = "UPDATE GHTK.Shipper as A\n" +
                "SET A.numberShipper = '" + newNumber + "' \n" +
                "WHERE A.idShipper = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Success(true, "Number is updated for user " + id);
            } else {
                object = new Error(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateMailShipper(String id, String newMail) {
        Object object = null;

        String update = "UPDATE GHTK.Shipper as A\n" +
                "SET A.mailShipper = '" + newMail + "' \n" +
                "WHERE A.idShipper = '" + id + "';";

        if (ValidateMail.validate(newMail)) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(update);
                int rowsEffected = preparedStatement.executeUpdate();
                if (rowsEffected != 0) {
                    object = new Success(true, "Mail is updated for user " + id);
                } else {
                    object = new Error(false, "Unknown id :" + id);
                }
            } catch (SQLException e) {
                object = new Error(false, e.getMessage());
            }
        } else {
            object = new Error(false, "Invalid mail format!");
        }

        return object;
    }
}

