package com.example.GHTK.Ultilities;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Database database;

    public static Database getDatabase() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    public static Connection connection;

    static {
        String url = "jdbc:mysql://localhost:3306/ightk";
        String username = "root";
        String password = "0944988947t";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
