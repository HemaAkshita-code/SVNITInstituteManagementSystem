package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.Login.Login;


public class StudentLogin<T> implements Login<T>
{
	
	Connection con = null;
    Statement stmt = null;
    Statement stmt1 = null;
    Statement stmt2 = null;
	
	public String userid = "null";
	private String passkey;
	
	public int currentSem = 1;
	String department;
	String graduationStatus;
	String name = null;
	long contactno = 0;
	
	public StudentLogin()
	{
		
	}
	
	public void createAccount(String username, String name, long contactno) 
	{		
		Scanner scanner = new Scanner(System.in);
		this.name = name;
		this.contactno = contactno;
		
		try
		{ 
			Class.forName("com.mysql.cj.jdbc.Driver");

	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentLoginCredentials","root", "leaf");
	        stmt = con.createStatement();
			
			ResultSet passwrd = stmt.executeQuery("select password from LoginCredentials where username = '" + username + "'");
			
			currentSem = StudentServices.getSemester(username);
			
			if(currentSem > 8 || currentSem < 1)
            {
            		throw new InvalidEmailIDException("Invalid User ID! please try again.");
            }
			else if(passwrd.next())
			{
				throw new AccountAlreadyExistsException("An account already exists with this username!");
			}
			else if(username.contains("@") && username.endsWith(".svnit.ac.in"))
			{
				passkey = (username.split("@"))[0] + "!23";

				try
			    {
					String Table = "CourseTracker_" + username.split("@")[0];
			        stmt.executeUpdate("INSERT INTO LoginCredentials VALUES('" + username + "', '" + passkey + "', '" + name + "', '" + contactno + "')");
			        String createTable = "CREATE TABLE " +Table+ "(course VARCHAR(30), status VARCHAR(5), grade VARCHAR(3), credits INT)";
			        stmt.execute(createTable);
			        
			        Table = "academicperformance_" + username.split("@")[0];
			        createTable = "CREATE TABLE " +Table+ "(semester INT, SGPA DOUBLE, credits INT)";
			        stmt.execute(createTable);
			    }
			    
			    catch(SQLException e)
			    {
			        e.printStackTrace();
			    }
			    finally
			    {
			        try
			        {
			            if(stmt != null)
			            {
			                stmt.close();
			                stmt = null;
			            }
			        }
			        catch(SQLException e)
			        {
			            e.printStackTrace();
			        }

			        try
			        {
			            if(con != null)
			            {
			                con.close();
			                con = null;
			            }
			        }
			        catch(SQLException e)
			        {
			            e.printStackTrace();
			        }
			    }
				
				userid = username;
				this.department = userid.substring(3,5);
				graduationStatus = userid.substring(0,1);
				
				System.out.println("Account created successfully");
			}
			else
			{
				throw new InvalidEmailIDException("Invalid User ID! please try again.");
			}
			
		}
		catch(InvalidEmailIDException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch(AccountAlreadyExistsException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch(SQLException e)
	    {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}

	public void getLoginCredentials(String username, String Password) 
	{
		userid = username;
		passkey = Password;
		this.department = userid.substring(3,5);
		graduationStatus = userid.substring(0,1);
		currentSem = StudentServices.getSemester(username);
		
		return;
	}

	public boolean verifyPassword(String username, String Password) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentLoginCredentials","root", "leaf");
	        stmt = con.createStatement();
	        stmt1 = con.createStatement();
	        stmt2 = con.createStatement();
	        
			ResultSet password = stmt.executeQuery("select password from LoginCredentials where username = '" + username + "'");
			ResultSet stName = stmt1.executeQuery("select name from LoginCredentials where username = '" + username + "'");
			ResultSet contact = stmt2.executeQuery("select contactno from LoginCredentials where username = '" + username + "'");
			
			
			if(password.next() &&  stName.next() && contact.next())
			{
				String passk = password.getString("Password");
				String stname = stName.getString("name");
				long contactNo = contact.getLong("contactno");
				
				if(passk.equals(Password))
				{
					this.name = stname;
					this.contactno = contactNo;
					return true;
				}
				else
				{
					System.out.println("Invalid password!");
				}
			}
			else
			{
				throw new UserNotFoundException("User not found! \nDon't have an account? Create one.");
			}
		}
		catch(UserNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		return false;
		
	}

	public T directAccount() 
	{	
		if(verifyPassword(userid, passkey))	
		{
			System.out.println("Login Successful");
			return (T) new Student(userid, name, contactno);
		}
		
		return null;
	}
	
	public void changePassword(String username, String existingPassword, String newPassword)
	{
			if(verifyPassword(username, existingPassword))
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");

			        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentLoginCredentials","root", "leaf");
			        stmt = con.createStatement();
			        
					stmt.executeUpdate("UPDATE LoginCredentials SET password = '" + newPassword + "' WHERE username = '" + username + "' ");
				}
				catch(SQLException ex)
				{
					System.out.println(ex.getMessage());
				} catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
				
				passkey = newPassword;
				System.out.println("Password changed successfully");
			}
	}
	
}
