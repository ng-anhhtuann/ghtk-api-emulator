package com.example.GHTK.Repository;

import com.example.GHTK.Model.AdminRight.Service;
import com.example.GHTK.Model.AdminRight.TimeLine;
import com.example.GHTK.Model.AdminRight.Type;
import com.example.GHTK.Model.Status.Error;
import com.example.GHTK.Model.Status.Success;
import com.example.GHTK.Model.AdminRight.Area;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

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

        String insert = "INSERT INTO SQLAPI.Area(idArea,nameArea,timeCreated) VALUES (?,?,?)";
        String count = "SELECT idArea FROM GHTK.Area ORDER BY idArea DESC LIMIT 0,1;";

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement(count);
        ResultSet resultSet = ps.executeQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            int num = resultSet.getInt(1)+1;
            preparedStatement.setString(1,"KV"+num);
            preparedStatement.setString(2, area.getNameArea());
            preparedStatement.setString(3,timeCreated);

            object = new Success(true, area.toString());
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

        String insert = "INSERT INTO SQLAPI.Service(idService,nameService,timeCreated) VALUES (?,?,?)";
        String count = "SELECT idService FROM GHTK.Service ORDER BY idService DESC LIMIT 0,1;";

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement(count);
        ResultSet resultSet = ps.executeQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            int num = resultSet.getInt(1)+1;
            preparedStatement.setString(1,"KV"+num);
            preparedStatement.setString(2, service.getNameService());
            preparedStatement.setString(3,timeCreated);

            object = new Success(true, service.toString());
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

        String insert = "INSERT INTO SQLAPI.Time(idTime,nameTime,timeCreated) VALUES (?,?,?)";
        String count = "SELECT idTime FROM GHTK.Time ORDER BY idTime DESC LIMIT 0,1;";

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement(count);
        ResultSet resultSet = ps.executeQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            int num = resultSet.getInt(1)+1;
            preparedStatement.setString(1,"KV"+num);
            preparedStatement.setString(2, timeLine.getDescription());
            preparedStatement.setString(3,timeCreated);

            object = new Success(true, timeLine.toString());
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

        String insert = "INSERT INTO SQLAPI.Time(idType,nameType,timeCreated) VALUES (?,?,?)";
        String count = "SELECT idType FROM GHTK.Area ORDER BY idType DESC LIMIT 0,1;";

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement(count);
        ResultSet resultSet = ps.executeQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            int num = resultSet.getInt(1)+1;
            preparedStatement.setString(1,"KV"+num);
            preparedStatement.setString(2, type.getNameProduct());
            preparedStatement.setString(3,timeCreated);

            object = new Success(true, type.toString());
        } catch (Exception e) {
            object = new Error(false, e.getMessage());
        }
        return object;
    }
//    public Object query(TimeLine timeLine) throws SQLException {
//        Object object = null;
//        if (timeLine == null) {
//            object = new Error(false, "We dont accept null information here");
//        }
//        /*
//        Date time create and add this field
//         */
//        String timeCreated = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());
//
//        String insert = "INSERT INTO SQLAPI.Time(idTime,nameTime,timeCreated) VALUES (?,?,?)";
//        String count = "SELECT COUNT(*) FROM GHTK.Time;";
//
//        Connection connection = DriverManager.getConnection(url, username, password);
//        PreparedStatement ps = connection.prepareStatement(count);
//        ResultSet resultSet = ps.executeQuery();
//
//        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
//            int num = resultSet.getInt(1)+1;
//            preparedStatement.setString(1,"KV"+num);
//            preparedStatement.setString(2, timeLine.getDescription());
//            preparedStatement.setString(3,timeCreated);
//
//            object = new Success(true, timeLine.toString());
//        } catch (Exception e) {
//            object = new Error(false, e.getMessage());
//        }
//        return object;
//    }
}
