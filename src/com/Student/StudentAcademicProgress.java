package com.Student;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class StudentAcademicProgress 
{
    String username;
    int currentSem;
    String dept;
    double sGPA = 0;
    double cGPA = 0;    
    
    Connection con = null;

    public StudentAcademicProgress(String username, int currentSem) 
    {
        this.username = username;
        this.currentSem = currentSem;
        this.dept = username.substring(3,5).toLowerCase();  // normalize

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/StudentLoginCredentials",
                "root",
                "leaf"
            );

            String trackerTable = "coursetracker_" + username.split("@")[0];
            String performanceTable = "academicperformance_" + username.split("@")[0];

            Statement stmt = con.createStatement();

          
            stmt.executeUpdate("TRUNCATE TABLE " + performanceTable);

            
            ResultSet rs = stmt.executeQuery(
                "SELECT status, course, grade, credits FROM " + trackerTable
            );

            int sem = 1;

            while(rs.next() && sem <= currentSem)
            {
                double totalPoints = 0;
                int totalCredits = 0;

                String status = rs.getString("status");
                String course = rs.getString("course").trim();   // 🔥 FIX
                String grade = rs.getString("grade").trim();
                int credits = rs.getInt("credits");

               
                int gradePoint = getGradePoint(grade);

                totalPoints += gradePoint * credits;
                totalCredits += credits;

               
                if(totalCredits != 0)
                    sGPA = totalPoints / totalCredits;
                else
                    sGPA = 0;

                // ✅ Store SGPA
                String insert = "INSERT INTO " + performanceTable + 
                                " (semester, SGPA, credits) VALUES (?, ?, ?)";

                PreparedStatement ps = con.prepareStatement(insert);
                ps.setInt(1, sem);
                ps.setDouble(2, sGPA);
                ps.setInt(3, totalCredits);
                ps.executeUpdate();

                cGPA += sGPA;

               
                if(status.equalsIgnoreCase("false"))
                    break;

                sem++;
            }

           
            if(sem > 1)
                cGPA = cGPA / (sem - 1);
            else
                cGPA = 0;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // 🔥 Clean grade conversion
    private int getGradePoint(String grade) throws IllegalGradeTypeException
    {
        switch(grade.toUpperCase())
        {
            case "AA": return 10;
            case "AB": return 9;
            case "BB": return 8;
            case "BC": return 7;
            case "CC": return 6;
            case "CD": return 5;
            case "DD": return 4;
            case "F":  return 0;
            default:
                throw new IllegalGradeTypeException("Invalid grade: " + grade);
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
