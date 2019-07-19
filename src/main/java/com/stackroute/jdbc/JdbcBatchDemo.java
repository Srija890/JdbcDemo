package com.stackroute.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatchDemo {
    public void batchDemo()
    {
        System.out.println("JdbcBatchDemo");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Connection connection= null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","Root@123");
            connection.setAutoCommit(false);
            Statement stmt=connection.createStatement();
            stmt.addBatch("insert into Employee values(5,'sweety',22,'female')");
            stmt.addBatch("insert into Employee values(8,'lucky',22,'female')");
            stmt.executeBatch();//executing the batch

            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }}