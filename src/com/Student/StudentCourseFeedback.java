package com.Student;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentCourseFeedback 
{
	
	Scanner scanner = new Scanner(System.in);
	String feedbackInput = null;
	String username;
	String course;
	int currentSem;
	String dept;
	
	Connection con = null;
    Statement stmt = null;
    Statement stmt1 = null;
	
	public StudentCourseFeedback(String username, int currentSem) 
	{
		this.username = username;
		this.currentSem = currentSem;
		this.dept = username.substring(3,5);
	}
	
	public void showPendingCourses()
	{
	    int flag = 0;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentLoginCredentials","root", "leaf");
	        stmt = con.createStatement();
	        stmt1 = con.createStatement();
	        
	        String Table = "coursetracker_" + username.split("@")[0];

			ResultSet status = stmt.executeQuery("select status from " +Table);
			ResultSet course = stmt1.executeQuery("select course from " +Table);
			
			if(!(status.next() && course.next()))
			{
				throw new FeedbackNotAcceptedException("The feedback section is closed at the moment.");
			}
			
			System.out.println("The available courses to give feedback are : ");
			
			do
			{
				String determiner = status.getString("status");
				String courseName = course.getString("course");
				
				if(determiner.equals("false"))
				{
					flag = 1;
					System.out.println("-" + courseName);
				}
			}while(status.next() && course.next());
			
			if(flag == 0)
			{
				throw new FeedbackNotAcceptedException("The feedback section is closed at the moment.");
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(FeedbackNotAcceptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public void giveFeedback(String course)
	{
		int flag = 0;
		int flag1 = 1;
		String prof1 = null;
		this.course = course;
		
		BufferedOutputStream bos = null;
		Calendar cal=Calendar.getInstance();
		
		
	
		try
		{	
	        prof1 = getprof1(course);
			
			System.out.println("Write your feedback:");
			feedbackInput = scanner.nextLine();
			
			String fileName = "D://" + course + prof1 + "feedback.txt";
			bos = new BufferedOutputStream(new FileOutputStream(fileName, true));
			bos.write(feedbackInput.getBytes());
			bos.write(("\n" + cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.YEAR) + "\n\n").getBytes());
			System.out.println("Feedback stored successfully!");
			
			if(flag == 1)
			{
				currentSem++;
			}
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(bos != null)
				{
					bos.flush();
					bos.close();
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}		
		
	}
	
	public File getComplaint(String course)
	{
		/*
		 
		String prof = getProfName(); // from professor
		
		*/
		
		String prof = "Dr. Praveen Kumar";
		
		File file = null;
		
		
		try
		{
			if(getprof1(course).equals(prof))
			{
				String fileName = "D://" + course + prof + "feedback.txt";
				file = new File(fileName);
				return file;
			}
			else
			{
				throw new FileCannotBeAccessedException("This file is not accessable.");
			}
		}
		catch (NullPointerException e)
		{
			e.printStackTrace();
		} 
		catch (FileCannotBeAccessedException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	String getprof1(String course)
	{
		int flag = 0;
		int flag1 = 1;
		String prof1 = null;
	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			

	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentLoginCredentials","root", "leaf");
	        stmt = con.createStatement();
	        	
	        String Table = "coursetracker_" + username.split("@")[0];
			
		
			ResultSet status = stmt.executeQuery("select status from " +Table+ " where course = '" +course+ "'");
			
			if(!(status.next()))
			{
				showPendingCourses();
				throw new CourseNotFoundException("The course is not available in your registered courses");
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
				
				StudentSchedule st = new StudentSchedule(username, currentSem);
				
				for (Map.Entry<String, List<String>> i : st.UDepartmentsDetails.get(dept).get(currentSem).get(0).entrySet())
				{
					if(i.getKey().trim().equals(course))
					{
						flag1 = 0;
						prof1 = i.getValue().get(0);
					}
					 
				}
				
				if(flag1 == 1)
				{
					if(flag == 1)
					{
						currentSem++;
					}
					showPendingCourses();
					throw new CourseNotFoundException("The course is not available to give feedback.");
				}
			}
		}
		catch (CourseNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	
		return prof1;
	}
}