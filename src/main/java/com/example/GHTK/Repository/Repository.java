package com.example.GHTK.Repository;

import com.example.GHTK.Model.AdminRight.Service;
import com.example.GHTK.Model.AdminRight.TimeLine;
import com.example.GHTK.Model.AdminRight.Type;
import com.example.GHTK.Model.Status.Error;
import com.example.GHTK.Model.Status.Success;
import com.example.GHTK.Model.AdminRight.Area;
import com.example.GHTK.Model.UserRight.Customer;

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
    API (rights only) for admin account
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
    Get customer's information by id or get all
     */
    public Object queryCustomer(){
        Object object = null;
        List<Customer> customerList = new ArrayList<>();

        String query = "SELECT * FROM GHTK.Customer;";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()){
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
            object = new Success(true,customerList.toString());
        } catch (SQLException e) {
            object = new Error(false,e.getMessage());
        }
        return object;
    }
    public Object queryCustomerById(String idCustomer){
        Object object = null;
        Customer customer = null;
        String query = "SELECT * FROM GHTK.Customer WHERE idCustomer ='"+idCustomer+"';";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()){
                customer = new Customer(resultSet.getString("idCustomer"),
                        resultSet.getString("nameCustomer"),
                        resultSet.getString("nameShop"),
                        resultSet.getString("areaCustomer"),
                        resultSet.getString("numberCustomer"),
                        resultSet.getString("addressCustomer"),
                        resultSet.getString("mailCustomer"),
                        resultSet.getString("taxCodeCustomer"));
                object = new Success(true,customer.toString());
            } else {
                object = new Error(false,"No customer with this id");
            }
        } catch (SQLException e) {
            object = new Error(false,e.getMessage());
        }
        return object;
    }
    public Object queryArea(){
        Object object = null;
        List<Area> areaList = new ArrayList<>();

        String query = "SELECT * FROM GHTK.Area;";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()){
                Area area = new Area(resultSet.getString("nameArea"));
                areaList.add(area);
            }
            object = new Success(true,areaList.toString());
        } catch (SQLException e) {
            object = new Error(false,e.getMessage());
        }
        return object;
    }
    public Object queryAreaById(String idArea){
        Object object = null;
        Area area = null;
        String query = "SELECT * FROM GHTK.Area WHERE idArea ='"+idArea+"';";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            if (resultSet.next()){
                area = new Area(resultSet.getString("nameArea"));
                object = new Success(true,area.toString());
            } else {
                object = new Error(false,"No area with this id");
            }
        } catch (SQLException e) {
            object = new Error(false,e.getMessage());
        }
        return object;
    }

}
