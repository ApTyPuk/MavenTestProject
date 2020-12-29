package org.example.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DBConnection {

    private final String URL = "jdbc:mysql://localhost:3306/new_schema?autoReconnect=true&useSSL=false";
    private final String USERNAME = "root";
    private final String PASSWORD = "Karbaher10";
    private Connection connection;

    public DBConnection() {

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Driver driver = new FabricMySQLDriver();
            DriverManager.deregisterDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

}