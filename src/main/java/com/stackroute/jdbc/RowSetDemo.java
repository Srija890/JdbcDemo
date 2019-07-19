package com.stackroute.jdbc;

import javax.sql.RowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class RowSetDemo {
    public void rowSetDemo()  {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        //Creating and Executing RowSet

        RowSet rowSet = null;

        try {
            rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/mysql");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");
            rowSet.setCommand("select * from Employee");
            rowSet.execute();
            while (rowSet.next())
            {
                System.out.println("Id: " + rowSet.getInt(1));
                System.out.println("Name: " + rowSet.getInt(2));
                System.out.println("Age: " + rowSet.getInt(3));
                System.out.println("Gender: " + rowSet.getInt(4));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}