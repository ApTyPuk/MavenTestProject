package org.example.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        DBConnection connection = new DBConnection();

        String query = "select * from person";

        try {
            Statement statement = connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                User user = new User();
//                user.setId(resultSet.getInt(1));
                user.setId(resultSet.getInt("ID"));
//                user.setFirstName(resultSet.getString(2));
                user.setFirstName(resultSet.getString("FIRST_NAME"));
                user.setLastName(resultSet.getString(3));
                user.setAddress(resultSet.getString(4));
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
