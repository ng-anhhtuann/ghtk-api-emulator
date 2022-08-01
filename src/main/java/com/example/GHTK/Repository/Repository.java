package com.example.GHTK.Repository;

import com.example.GHTK.Model.AdminRight.Service;
import com.example.GHTK.Model.AdminRight.TimeLine;
import com.example.GHTK.Model.AdminRight.Type;
import com.example.GHTK.Model.Custom.OrderDetails;
import com.example.GHTK.Model.Status.Error;
import com.example.GHTK.Model.Status.Success;
import com.example.GHTK.Model.AdminRight.Area;
import com.example.GHTK.Model.UserRight.Customer;
import com.example.GHTK.Model.UserRight.Shipper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.sql.*;
import java.util.List;

public class Repository {
    private static final String url = "jdbc:mysql://localhost:3306/GHTK";
    private static final String username = "root";
    private static final String password = "0944988947t";

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
    public Object insert(Area area) throws SQLException {
        Object object = null;
        if (area == null) {
            object = new Error(false, "We dont accept null information here");
        }
        /*
        Date time create and add this field
         */
        String timeCreated = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        Connection connection = DriverManager.getConnection(url, username, password);

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

    public Object insert(Service service) throws SQLException {
        Object object = null;
        if (service == null) {
            object = new Error(false, "We dont accept null information here");
        }
        /*
        Date time create and add this field
         */
        String timeCreated = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        Connection connection = DriverManager.getConnection(url, username, password);

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

    public Object insert(TimeLine timeLine) throws SQLException {
        Object object = null;
        if (timeLine == null) {
            object = new Error(false, "We dont accept null information here");
        }
        /*
        Date time create and add this field
         */
        String timeCreated = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        Connection connection = DriverManager.getConnection(url, username, password);

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

    public Object insert(Type type) throws SQLException {
        Object object = null;
        if (type == null) {
            object = new Error(false, "We dont accept null information here");
        }
        /*
        Date time create and add this field
         */
        String timeCreated = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        Connection connection = DriverManager.getConnection(url, username, password);

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
    public Object queryArea() {
        Object object = null;
        List<Area> areaList = new ArrayList<>();

        String query = "SELECT * FROM GHTK.Area;";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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

    public Object queryAreaById(String idArea) {
        Object object = null;
        Area area = null;
        String query = "SELECT * FROM GHTK.Area WHERE idArea ='" + idArea + "';";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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

    public Object queryTime() {
        Object object;
        List<TimeLine> timeList = new ArrayList<>();

        String query = "SELECT * FROM GHTK.Time;";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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

    public Object queryTimeById(String id) {
        Object object = null;
        TimeLine timeLine = null;
        String query = "SELECT * FROM GHTK.Time WHERE idTime ='" + id + "';";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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

    public Object queryService() {
        Object object = null;
        List<Service> serviceList = new ArrayList<>();

        String query = "SELECT * FROM GHTK.Service;";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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

    public Object queryServiceById(String id) {
        Object object = null;
        Service service = null;
        String query = "SELECT * FROM GHTK.Service WHERE idService ='" + id + "';";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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

    public Object queryType() {
        Object object = null;
        List<Type> typeList = new ArrayList<>();

        String query = "SELECT * FROM GHTK.Type;";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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

    public Object queryTypeById(String id) {
        Object object = null;
        Type type = null;
        String query = "SELECT * FROM GHTK.Type WHERE idType ='" + id + "';";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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

    public Object queryCustomer() {
        Object object = null;
        List<Customer> customerList = new ArrayList<>();

        String query = "SELECT * FROM GHTK.Customer;";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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

    public Object queryCustomerById(String id) {
        Object object = null;
        Customer customer = null;
        String query = "SELECT * FROM GHTK.Customer WHERE idCustomer ='" + id + "';";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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

    public Object queryShipper() {
        Object object = null;
        List<Shipper> shipperList = new ArrayList<>();

        String query = "SELECT * FROM GHTK.Shipper;";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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

    public Object queryShipperById(String id) {
        Object object = null;
        Shipper shipper = null;
        String query = "SELECT * FROM GHTK.Shipper WHERE idShipper ='" + id + "';";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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
                "FROM GHTK.Order as A INNER JOIN GHTK.Customer as B ON A.idshopOrder = B.idCustomer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.Service as C ON A.idserviceOrder = C.idService\n" +
                "                     INNER JOIN GHTK.Shipper as D ON A.idshipperOrder = D.idShipper\n" +
                "                     INNER JOIN GHTK.Time as E ON A.idtimeOrder = E.idTime\n" +
                "                     INNER JOIN GHTK.Type as F ON A.idtypeOrder = F.idType;";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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

    public Object queryOrderById(String id) {
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
                "FROM GHTK.Order as A INNER JOIN GHTK.Customer as B ON A.idshopOrder = B.idCustomer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.Service as C ON A.idserviceOrder = C.idService\n" +
                "                     INNER JOIN GHTK.Shipper as D ON A.idshipperOrder = D.idShipper\n" +
                "                     INNER JOIN GHTK.Time as E ON A.idtimeOrder = E.idTime\n" +
                "                     INNER JOIN GHTK.Type as F ON A.idtypeOrder = F.idType" +
                "WHERE idOrder = '" + id + "';";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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
                "FROM GHTK.Order as A INNER JOIN GHTK.Customer as B ON A.idshopOrder = B.idCustomer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.Service as C ON A.idserviceOrder = C.idService\n" +
                "                     INNER JOIN GHTK.Shipper as D ON A.idshipperOrder = D.idShipper\n" +
                "                     INNER JOIN GHTK.Time as E ON A.idtimeOrder = E.idTime\n" +
                "                     INNER JOIN GHTK.Type as F ON A.idtypeOrder = F.idType" +
                "WHERE approveOrder = 0;";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
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

}
