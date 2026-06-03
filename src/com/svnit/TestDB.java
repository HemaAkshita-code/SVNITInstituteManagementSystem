package com.svnit;
import java.sql.Connection;

public class TestDB {

    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        if (con != null) {
            System.out.println("Connected successfully!");
      
        AdminDAO dao = new AdminDAO();

        dao.addCourse("Java", 60);
        dao.viewCourses();
        }
        else {
            System.out.println("Connection failed!");
        }
    }
}


