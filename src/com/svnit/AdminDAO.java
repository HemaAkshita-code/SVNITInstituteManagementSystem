package com.svnit;

import java.sql.*;
import com.Student.StudentComplaints;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AdminDAO {

    //add course`
    public void addCourse(String name, int capacity) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO course(name, capacity) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, capacity);

            ps.executeUpdate();

            System.out.println("Course "+name+" added successfully!");

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
   

    //view course
    public void viewCourses() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM course";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                        rs.getString("name") + " - " +
                        rs.getInt("capacity")
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //delete course
    public void deleteCourse(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM course WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Course deleted!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //view records
    public void viewRecords()
    {
    	Connection con = null;
    	try {
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");

	       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentLoginCredentials","root", "leaf");
          
            String query = "SELECT * FROM LoginCredentials";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        rs.getString("username") + " | " +
                        rs.getString("password") + " | " +
                        rs.getString("name")+"|"+rs.getLong("contactno")
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    	catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
 }
    //updateRecords
    public void updateRecords(String username, String password, String name, int contact_no)
    {
	    	Connection con;
	    	
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");

	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentLoginCredentials","root", "leaf");
            String query = "UPDATE logincredentials SET password=?, contactno=?, name=? WHERE username=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, password);
            ps.setInt(2, contact_no);
            ps.setString(3, name);
            ps.setString(4, username);

            ps.executeUpdate();

        } catch(SQLException ex) {
            ex.printStackTrace();
        } 
        catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }	
    
  //update cgpa
    public void updateGrade(String username,String subject,String grade, int credits)
    {
    	Connection con;
        try {
        		Class.forName("com.mysql.cj.jdbc.Driver");

	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentLoginCredentials","root", "leaf");
	       
            String tracker = "coursetracker_" + username.split("@")[0];
            String query="UPDATE "+tracker+" SET grade=?,status=?, credits=? where course=?";


            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, grade);
            ps.setString(2, "true");
            ps.setString(4,subject);
            ps.setInt(3,credits);
           

            ps.executeUpdate();

        } catch(SQLException ex) {
            ex.printStackTrace();
        } 
        catch (ClassNotFoundException e) {
        	
			e.printStackTrace();
		}
    }
    
public void viewComplaints()
    {
        try {
            StudentComplaints sc = new StudentComplaints();
            File f = sc.getComplaint();

            if (!f.exists()) {
                System.out.println("No complaints found!");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(f));

            String line;
            System.out.println("----- Complaints -----");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    

 public void updateComplaintStatus()
    {
        try {
            StudentComplaints sc = new StudentComplaints();
            File f = sc.getComplaint();

            if (!f.exists()) {
                System.out.println("File not found!");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(f));
            List<String> list = new ArrayList<>();

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter complaint message: ");
            String target = input.readLine();

            System.out.print("Enter new status: ");
            String newStatus = input.readLine();

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(" \\| ");

                if (parts[0].equalsIgnoreCase(target)) {
                    list.add(parts[0] + " | " + newStatus);
                } else {
                    list.add(line);
                }
            }

            br.close();

            FileWriter fw = new FileWriter(f, false);

            for (String s : list) {
                fw.write(s + "\n");
            }

            fw.close();

            System.out.println("Updated successfully!");

        } 
        catch(IOException ex)
        {
        	ex.printStackTrace();
        }
    }
    
    
     
}
