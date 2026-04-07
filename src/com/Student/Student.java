package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student
{	
	String userid;
    String dept;
    int currentSem;
    
    public StudentCourses courses;
    public StudentComplaints complaints;
    public StudentRegisterCourses register;
    public StudentSchedule schedule;
    public StudentLogin login;
    public StudentDropCourses drop;
    public StudentAcademicProgress academic;
    public StudentCourseFeedback feedback;

    Student(String userid, int currentSem, String name, long contactno) 
    {
        this.userid = userid;
        this.dept = userid.substring(3,5);
        this.currentSem = currentSem;
        
		System.out.println("Student admitted " + userid);
       
        courses = new StudentCourses(userid, currentSem);
        complaints = new StudentComplaints();
        register = new StudentRegisterCourses(userid, currentSem, name, contactno);
        schedule = new  StudentSchedule(dept, currentSem);
        login = new StudentLogin();
        drop = new StudentDropCourses(userid, currentSem, name, contactno);
        academic = new StudentAcademicProgress(userid, currentSem);
        feedback = new StudentCourseFeedback(userid, currentSem);
        
    }
}