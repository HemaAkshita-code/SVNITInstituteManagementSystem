package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentAcademicProgress 
{
	String username;
	int currentSem;
	String dept;
	double sGPA = 0;
	double cGPA = 0;	
	
	Connection con = null;
	Statement stmt = null;
    Statement stmt1 = null;
    Statement stmt2 = null;
    Statement stmt3 = null;
    Statement stmt4 = null;
    
    public StudentAcademicProgress(String username, int currentSem) 
    {
		this.username = username;
		this.currentSem = currentSem;
		this.dept = username.substring(3,5);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentLoginCredentials","root", "leaf");
	        stmt = con.createStatement();
	        stmt1 = con.createStatement();
	        stmt2 = con.createStatement();
	        stmt3 = con.createStatement();
	        stmt4 = con.createStatement();
			
	        String Table = "academicperformance_"+ username.split("@")[0];
	        
	        stmt.executeUpdate("TRUNCATE TABLE " +Table);
	        
	        Table = "coursetracker_" + username.split("@")[0];
	        
			ResultSet status = stmt1.executeQuery("select status from " +Table);
			ResultSet course = stmt2.executeQuery("select course from " +Table);
			ResultSet grade = stmt3.executeQuery("select grade from " +Table);
			ResultSet credits = stmt4.executeQuery("select credits from " +Table);
			
			int i = 1;
			String determiner = null;
			String semDeterminer = null;
			String gradeDeterminer = null;
			int gradeNumber;
			int NoOfCredits = 0;
			int semCredits;
			int flag = 0;

			while(status.next() && course.next() && grade.next() && credits.next() && i <= currentSem ) //what if first determiner is false
			{
				StudentCourses st = new StudentCourses(username, i);
				semCredits = 0;
				
				while(flag == 0 || (st.UDepartments.get(dept).get(i).contains(semDeterminer) && determiner.equals("true")))
				{			
					if(flag == 1)
					{
						switch(gradeDeterminer)
						{
							case "AA":
								gradeNumber = 10;
								break;
								
							case "AB":
								gradeNumber = 9;
								break;
								
							case "BB":
								gradeNumber = 8;
								break;
								
							case "BC":
								gradeNumber = 7;
								break;
								
							case "CC":
								gradeNumber = 6;
								break;
								
							case "CD":
								gradeNumber = 5;
								break;
								
							case "DD":
								gradeNumber = 4;
								break;
								
							case "F":
								gradeNumber = 3;
								break;
								
							default:
								throw new IllegalGradeTypeException("The grade type is not accepted!");
						}
						
						sGPA += gradeNumber * NoOfCredits;
						semCredits += NoOfCredits;
					}
					
					flag = 1;
					determiner = status.getString("status");
					semDeterminer = course.getString("course");
					gradeDeterminer = grade.getString("grade");
					NoOfCredits = credits.getInt("credits");
					
				}
				
				if(semCredits == 0)
				{
					sGPA = 0;
				}
				else
				{
					sGPA /= semCredits;
				}
				
				Table = "academicperformance_" + username.split("@")[0];
				String sGPAUpdation = "INSERT INTO " +Table+ "(semester, SGPA, credits) VALUES (?, ?, ?)";

				PreparedStatement ps = con.prepareStatement(sGPAUpdation);
				ps.setInt(1, i);
				ps.setDouble(2, sGPA);
				ps.setInt(3, semCredits);

				ps.executeUpdate();
				
				cGPA += sGPA; 

				i++;
				
				if(determiner.equals("flase"))
				{
					break;
				}
			}
			
			cGPA /= i-1;
			
		}
		catch(IllegalGradeTypeException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
    
    public double getCGPA()
	{
        	return cGPA;
	}
    
    public double getSGPA()
	{
        	return sGPA;
	}
	
}
