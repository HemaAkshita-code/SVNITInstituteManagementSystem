package com.User;

import com.Login.Login;

import java.io.File;
import java.util.Scanner;
import com.Student.*;

public class ApplicationUser 
{
	public static void main(String[] args) 
	{
		
/*
		
		Login student1 = new StudentLogin();
		
		student1.createAccount("u20ai800@aid.ac.svnit.in");
		((StudentLogin) student1).changePassword("u25ai800@aid.ac.svnit.in", "u25ai800!23", "Brown@!23");
		student1.getLoginCredentials("u25ai800@aid.ac.svnit.in", "Brown@!23");
		
		
		try
		{
		    student1 = student1.directAccount();
			((StudentCourses) student1).viewCourses(); //!!!!!!!!!!!!!!!
		}
		catch(NullPointerException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		System.out.println("============================");
		
		Login student2 = new StudentLogin();
		String userid = "u25ai888@aid.ac.svnit.in";
		student2.createAccount("u25ai888@aid.ac.svnit.in");
		student2.getLoginCredentials("u25ai888@aid.ac.svnit.in", "u25ai888!23");
		student2 = student2.directAccount();
		String dept = userid.substring(3,5);
		
		((StudentCourses) student2).viewCourses();
		System.out.println("Exited successfully.");
		
		student2 = new StudentComplaints();
		((StudentComplaints) student2).raiseComplaint();
		
		student2 = new StudentRegisterCourses(dept, 2);
		//((StudentRegisterCourses) student2).registerCourse("Maths");
		((StudentRegisterCourses) student2).registerCourse("Physics");
		
		System.out.println("========================");
		
		Login student3 = new StudentLogin();
		String userid3 = "u24ai888@aid.ac.svnit.in";
		
		student3.createAccount("u24ai888@aid.ac.svnit.in");
		student3.getLoginCredentials("u24ai888@aid.ac.svnit.in", "u24ai888!23");
		student3 = student3.directAccount();
		
		student3 = new StudentRegisterCourses(userid.substring(3,5), 4);
		((StudentRegisterCourses) student3).registerCourse("Astronomy");
		 
		*/
		
		/*
		Scanner scanner = new Scanner(System.in);
		
		String dept = null;
		int currentSem = 1;
		String username = null;
		
		System.out.println("Application User\n"
				+ "1. Admin\n"
				+ "2. Professor\n"
				+ "3. Student");
		
		int choice1 = scanner.nextInt();
		
		switch(choice1)
		{
			case 1:
				
			case 2:
				
			case 3:
				Login student1 = new StudentLogin(); //Later to be replaced with factory design pattern
				System.out.println("Don't have an account? "
						+ "\n1. create account"
						+ "\n2. login");
				
				int choice2 = scanner.nextInt();
				scanner.nextLine();
				
				switch(choice2)
				{
					case 1:
						System.out.println("Username:");
						username = scanner.nextLine();
						student1.createAccount(username);
						dept = username.substring(3,5);
						currentSem = ((StudentLogin)student1).currentSem;
						
					case 2:
						System.out.println("Enter your username and password");
						System.out.println("Username:");
						username = scanner.nextLine();
						System.out.println("Password:");
						String password = scanner.nextLine();
						
						//((StudentLogin) student1).changePassword(username, "u25ai800!23", "Brown@!23");
						student1.getLoginCredentials(username, password);
						
						
						try
						{
						    student1 = student1.directAccount();
							//((StudentCourses) student1).viewCourses(); //!!!!!!!!!!!!!!!
						}
						catch(NullPointerException ex)
						{
							System.out.println(ex.getMessage());
						}
												
				}
				
				int choice3 = 0;
				
				while(student1 != null && choice3 != 8)
				{
					System.out.println("The following features are available "
							+ "\n1. View Courses"
							+ "\n2. View Schedule"
							+ "\n3. Raise a complaint"
							+ "\n4. Register courses"
							+ "\n5. Drop a course"
							+ "\n6. view Academic Performance"
							+ "\n7. Change Password"
							+ "\n8. Logout");
					
					choice3 = scanner.nextInt();
					scanner.nextLine();
					
					switch(choice3)
					{
						case 1:
				
							((StudentCourses) student1).viewCourses();
							
							break;
							
						case 2:
						case 3:
							
							student1 = new StudentComplaints();
							((StudentComplaints) student1).raiseComplaint();
							
							break;
							
						case 4:
							
							student1 = new StudentRegisterCourses(dept, currentSem);
							((StudentRegisterCourses) student1).registerCourse("Physics");
							((StudentRegisterCourses) student1).registerCourse("Astronomy");
							
							break;
							
						case 5:
							
							student1 = new StudentDropCourses(dept, currentSem);
							((StudentDropCourses) student1).dropCourse("Physics");
							((StudentDropCourses) student1).dropCourse("Astronomy");
							
							break;
							
						case 6:
						case 7:
							
							System.out.println("Enter your username and existing password to verify it's you");
							System.out.println("Username:");
							username = scanner.nextLine();
							System.out.println("existing Password:");
							String password = scanner.nextLine();
							
							if(((StudentLogin) student1).verifyPassword(username, password))
							{
								System.out.println("New Password:");
								String newPassword = scanner.nextLine();
								
								((StudentLogin) student1).changePassword(username, password, newPassword);
							
							}
							
							break;
							
						case 8:
							break;
					}
				}
				
//			case 4:
//				exit();
		 }
		
		*/
		
//		StudentComplaints s = new StudentComplaints();
//		File f = s.getComplaint();
//		System.out.println(f.getName());
//		
		
//		StudentCourseFeedback s = new StudentCourseFeedback("u25ai042@aid.svnit.ac.in", 2);
//		
//		File f = s.getComplaint("IOP");
//		try
//		{
//			System.out.println(f.getName());
//		}
//		catch(NullPointerException e)
//		{
//			e.printStackTrace();
//		}
		
		Scanner scanner = new Scanner(System.in);
		
		String username = null;
		String courseName = null;
		Student student1 = null;
		
		System.out.println("Application User\n"
				+ "1. Admin\n"
				+ "2. Professor\n"
				+ "3. Student");
		
		int choice1 = scanner.nextInt();
		
		switch(choice1)
		{
			case 1:
				
			case 2:
				
			case 3:
				
				Login<Student> student  = new StudentLogin(); 
				
				System.out.println("Don't have an account? "
						+ "\n1. create account"
						+ "\n2. login");
				
				int choice2 = scanner.nextInt();
				scanner.nextLine();
				
				switch(choice2)
				{
					case 1:
						System.out.println("Username:");
						username = scanner.nextLine();
						student.createAccount(username);
						
					case 2:
						System.out.println("Enter your username and password");
						System.out.println("Username:");
						username = scanner.nextLine();
						System.out.println("Password:");
						String password = scanner.nextLine();
						
						student.getLoginCredentials(username, password);
						
						try
						{
							student1 = student.directAccount();
						}
						catch(NullPointerException ex)
						{
							System.out.println(ex.getMessage());
						}
												
				}
				
				int choice3 = 1;
				
				while(student1 != null && choice3 < 8 && choice3 > 0)
				{
					System.out.println("The following features are available "
							+ "\n1. View Courses"
							+ "\n2. View Schedule"
							+ "\n3. Raise a complaint"
							+ "\n4. Register courses"
							+ "\n5. Drop a course"
							+ "\n6. view Academic Performance"
							+ "\n7. Change Password"
							+ "\n8. Give Feedback"
							+ "\n9. Logout");
					
					choice3 = scanner.nextInt();
					scanner.nextLine();
					
					switch(choice3)
					{
						case 1:
				
							student1.courses.viewCourses();
							
							break;
							
						case 2:
							student1.schedule.viewSchedule();
							break;
						case 3:
							
							student1.complaints.raiseComplaint();
							
							break;
							
						case 4:
							
							System.out.println("Enter course to register: ");
							courseName = scanner.nextLine();
							student1.register.registerCourse(courseName);
							
							break;
							
						case 5:
							System.out.println("Enter course to drop: ");
							courseName = scanner.nextLine();
							student1.drop.dropCourse(courseName);
							
							break;
							
						case 6: 
							
							double sgpa = student1.academic.getSGPA();
							System.out.println("SGPA : " + sgpa);
							double cgpa = student1.academic.getCGPA();
							System.out.println("CGPA : " + cgpa);    //u25ai042@aid.svnit.ac.in
							break;
							
						case 7:
							
							System.out.println("Enter your username and existing password to verify it's you");
							System.out.println("Username:");
							username = scanner.nextLine();
							System.out.println("existing Password:");
							String password = scanner.nextLine();
							
							if(student1.login.verifyPassword(username, password))
							{
								System.out.println("New Password:");
								String newPassword = scanner.nextLine();
								
								student1.login.changePassword(username, password, newPassword);
							
							}
							
							break;
						
						case 8:
							System.out.println("Enter course to give feedback: ");
							courseName = scanner.nextLine();
							student1.feedback.giveFeedback(courseName);
							break;
							
						case 9:
							System.out.println("Logged out successfully!");
							break;
					}
				}
				
//			case 4:
//				exit();
		 }
		
	}
}

//u25ee090@aid.svnit.ac.in
