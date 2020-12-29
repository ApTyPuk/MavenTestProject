package org.example.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class MainPreparedStatement {

    private static final String INSERT_NEW = "INSERT INTO dish VALUES(?,?,?,?,?,?,?)";

    public static void main(String[] args) {
        DBConnection connection = new DBConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.getConnection().prepareStatement(INSERT_NEW);

            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Title");
            preparedStatement.setString(3, "Description");
            preparedStatement.setFloat(4, 0.2F);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setBlob(7, new FileInputStream("src\\main\\java\\org\\example\\database\\smile_logo.png"));

            preparedStatement.execute();

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
