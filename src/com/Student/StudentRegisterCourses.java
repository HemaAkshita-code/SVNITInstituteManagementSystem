package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class StudentRegisterCourses 
{
	int credits = 0;
	String course;
	String dept;
	int currentSem;
	String username;
	String name;
	long contactno;
	
	Connection con = null;
    Statement stmt = null;
			
	public StudentRegisterCourses(String username, int currentSem, String name, long  contactno) 
	{
		this.username = username;
		dept = username.substring(3,5);
		this.currentSem = currentSem;
		this.name = name;
		this.contactno = contactno;
	}

	boolean courseCompleted(String course)
	{
//		if(gradeAssigned(course))
//		{
//			
//			
//			return true;
//		}
		
		return false;
	}
	
	public void registerCourse(String course)
	{
		int flag = 0;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentLoginCredentials","root", "leaf");
	        stmt = con.createStatement();
	        
	        String Table = "coursetracker_" + username.split("@")[0];

			ResultSet status = stmt.executeQuery("select status from " +Table);
			
			if(!status.next())
			{
				currentSem = 1;
			}
			
			do
			{
				String determiner = status.getString("status");
				
				if(determiner.equals("false"))
				{
					flag = 1;
				}
			}while(status.next());
			
			
			if(currentSem < 8 && currentSem > 0)
			{	
				if(flag == 1 && currentSem > 1)
				{
					currentSem--;
				}
				
				StudentCourses st = new StudentCourses(username, currentSem);
				
				if(st.UDepartments.get(dept).get(currentSem).contains(course))
				{
					String courseRegistration = "INSERT INTO " +Table+ "(course, status, grade, credits) VALUES (?, ?, ?, ?)";

						PreparedStatement ps = con.prepareStatement(courseRegistration);
						ps.setString(1, course);
						ps.setString(2, "false");
						ps.setString(3, "-");
						ps.setInt(4, 0);

						ps.executeUpdate();
						
						Table = course.toLowerCase() + "coursestudentlist";
						String courseList = "INSERT INTO " +Table+ "(username, name, contactno) VALUES (?, ?, ?)";

						ps = con.prepareStatement(courseList);
						ps.setString(1, username);
						ps.setString(2, name);
						ps.setLong(3, contactno);

						ps.executeUpdate();
						
					System.out.println("Course " + course + " registered successfully!");
					
					if(flag == 1)
					{
						currentSem ++;
					}
					
				}
				else if(flag == 0)
				{
					throw new InvalidRegistrationException("This course is not available in the current semester for registering.");
				}
				else
				{
					throw new PrerequisitesNotMetException("Course(s) from previous semester is not completed!");
				}
			}
			else
			{
				throw new InvalidRegistrationException("You are not eligible for registering courses.");
			}
		
			
			
			if(credits > 20)
			{
				throw new CreditLimitExceededException("credits limit exceeded!");
			}
		}
		catch(PrerequisitesNotMetException ex)
		{
			ex.printStackTrace();
		}
		catch(CreditLimitExceededException ex)
		{
			ex.printStackTrace();
		}
		catch(InvalidRegistrationException ex)
		{
			ex.printStackTrace();
		}
		//viewCourses();
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
}

class CreditLimitExceededException extends Exception
{
	public CreditLimitExceededException(String msg) 
	{
		super(msg);
	}
}

class PrerequisitesNotMetException extends Exception
{
	public PrerequisitesNotMetException(String msg) 
	{
		super(msg);
	}
}

class InvalidRegistrationException extends Exception
{
	public InvalidRegistrationException(String msg) 
	{
		super(msg);
	}
}
