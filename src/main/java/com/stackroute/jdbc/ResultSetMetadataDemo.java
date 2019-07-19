package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    public void resultSetDemo()
    {
        System.out.println("ResultSetMetadata");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql","root","Root@123");

            PreparedStatement preparedStatement=connection.prepareStatement("select * from Employee");
            ResultSet resultSet=preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData=preparedStatement.getMetaData();

            System.out.println("Total columns: "+resultSetMetaData.getColumnCount());
            System.out.println("Column Name of 1st column: "+resultSetMetaData.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+resultSetMetaData.getColumnTypeName(1));

            connection.close();
        }catch(Exception e){ System.out.println(e);}
    }
}