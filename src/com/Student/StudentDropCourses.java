package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDropCourses 
{	
	String dept;
	int currentSem;
	String username;
	String name;
	long contactno;
	
	Connection con = null;
    Statement stmt = null;
	
	public StudentDropCourses(String username, int currentSem, String name, long  contactno) 
	{
		this.currentSem = currentSem;
		dept = username.substring(1,3);
		this.username = username;
		this.name = name;
		this.contactno = contactno;
	}
	
	public boolean dropCourse(String course)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentLoginCredentials","root", "leaf");
	        stmt = con.createStatement();
	        
	        String Table = "coursetracker_" + username.split("@")[0];
			
			ResultSet status = stmt.executeQuery("select status from " +Table+ " where course = '" +course+ "'");
			
			if(status.next())
			{
				String determiner = status.getString("status");
				if(determiner.equals("true"))
				{
					throw new CourseCannotBeDroppedException("This course is not available to drop since it is already completed");
				}
				else
				{
					stmt.executeUpdate("delete from " +Table+ " where course = '" +course+ "'");
					Table = course.toLowerCase() + "coursestudentlist";
					stmt.executeUpdate("delete from " +Table+ " where username = '" +username+ "'");
					System.out.println(course + " dropped successfully!");
				}
			}
			
			else
			{
				throw new CourseCannotBeDroppedException("This course is not available to drop since it was not registered");
			}
			
		}
		catch(CourseCannotBeDroppedException e)
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
}

