package com.svnit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.Login.Login;
import com.Student.UserNotFoundException;
import com.svnit.AdminDAO;

public class AdminLogin<T> implements Login<T> 
{

    private String username;
    private String password;

    //user gives it
    public void getLoginCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // login page
    public boolean verifyPassword(String username, String password) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM admin WHERE username=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("password");

                if (dbPassword.equals(password)) {
                    System.out.println("Login successful!");
                    return true;
                } else {
                    System.out.println("Wrong password!");
                    return false;
                }

            } else {

            		throw new UserNotFoundException("Account does not exist with this username");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } catch (UserNotFoundException e) {
			
			e.printStackTrace();
		}
        
		return false;
    }

   
    public void createAccount(String username, String name, long contactno) 
    {
    		try {
            Connection con = DBConnection.getConnection();
            System.out.println("User not found. Creating new account...");

	         String insertQuery = "INSERT INTO admin(username, password) VALUES (?, ?)";
	         PreparedStatement ps2 = con.prepareStatement(insertQuery);
	
	         ps2.setString(1, username);
	         ps2.setString(2, "Khwaish@17");
	
	         ps2.executeUpdate();
	
	         System.out.println("Account created!");
	         System.out.println("Please login again with password");
    		}
    		catch (SQLException ex) {
                ex.printStackTrace();
            }
    }

    //final method???
    public T directAccount() {

        boolean success = verifyPassword(username, password);

        if (success) {
        	System.out.println("Logging you in....");
        	return (T) new AdminDAO();
        } 
        else {
            return null;
        }
       
    }
   
}
