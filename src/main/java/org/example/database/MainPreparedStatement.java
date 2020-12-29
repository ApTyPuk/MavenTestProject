package org.example.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class MainPreparedStatement {

    private static final String INSERT_NEW = "INSERT INTO dish VALUES(?,?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM dish";
    private static final String DELETE = "DELETE FROM dish WHERE id=?";

    public static void main(String[] args) {
        DBConnection connection = new DBConnection();
        PreparedStatement preparedStatement = null;

        try {
//            #1 INSERT_NEW
//            preparedStatement = connection.getConnection().prepareStatement(INSERT_NEW);

//            preparedStatement.setInt(1, 2);
//            preparedStatement.setString(2, "Title");
//            preparedStatement.setString(3, "Description");
//            preparedStatement.setFloat(4, 0.2F);
//            preparedStatement.setBoolean(5, true);
//            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
//            preparedStatement.setBlob(7, new FileInputStream("src\\main\\java\\org\\example\\database\\smile_logo.png"));
//            preparedStatement.execute();

//            #3 DELETE
            preparedStatement = connection.getConnection().prepareStatement(DELETE);
            preparedStatement.setInt(1, 2); //1 - first in queue with ID= 2;
            preparedStatement.executeUpdate();

//            #2 GET_ALL
            preparedStatement = connection.getConnection().prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                float rating = resultSet.getFloat("rating");
                boolean published = resultSet.getBoolean("published");
                Date date = resultSet.getDate("created");
                byte[] icon = resultSet.getBytes("icon");

                System.out.println("id: " + id +
                        ", title: " + title +
                        ", description: " + description +
                        ", rating: " + rating +
                        ", published: " + published +
                        ", date: " + date +
                        ", icon: " + icon.length
                );
            }


//        } catch (SQLException | FileNotFoundException e) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
