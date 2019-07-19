package com.stackroute.jdbc;
import java.sql.*;

public class JdbcTransactionDemo {

    public void getjdbcTransactionDemo() {
        System.out.println("JdbcTransactionDemo");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from Employee");) {
            connection.setAutoCommit(false);
            statement.executeUpdate("insert into Employee values(1,'srija',40,'female')");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}