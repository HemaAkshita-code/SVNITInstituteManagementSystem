package com.svnit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/university",
                "root",
                "leaf"
            );

            return con;

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
        catch(SQLException ex)
        {
        	ex.printStackTrace();
        	return null;
        }
    }
}