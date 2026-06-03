package com.User;

import com.Login.Login;
import java.io.File;
import java.util.Scanner;
import com.Student.*;
import com.admin.AssignProfessor;
import com.svnit.AdminDAO;
import com.svnit.AdminLogin;

public class ApplicationUser 
{
	public static void main(String[] args) 
	{
		
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
				
				        Scanner sc = new Scanner(System.in);

				        System.out.println("===== ADMIN PANEL =====");

				        //user enters-login
				        System.out.print("Enter Username- ");
				        String username1 = sc.nextLine();

				        System.out.print("Enter Password- ");
				        String password = sc.nextLine();

				        Login<AdminDAO> loginObj = new AdminLogin();

				        loginObj.getLoginCredentials(username1, password);

				        AdminDAO admin1 = null;
				        
				        try
						{
							admin1 = loginObj.directAccount();
						}
						catch(NullPointerException ex)
						{
							System.out.println(ex.getMessage());
						}
				        
				        

				        while (admin1 != null) {

				            System.out.println("\n^^^^^^ MENU ^^^^^^  ");
				            System.out.println("1. Add Course");
				            System.out.println("2.Delete Course");
				            System.out.println("3.View Course");
				            System.out.println("4. View Complaints");
				            System.out.println("5. Update Complaint Status");
				            System.out.println("6. Update Student Records");
				            System.out.println("7. View Student Records");
				            System.out.println("8. Assign professor");
				            System.out.println("9. Update Student Grades");
				            System.out.println("10. Exit");

				            System.out.print("Enter choice: ");
				            int choice = sc.nextInt();
				            sc.nextLine();

				            switch (choice) {

				                case 1:
				                    System.out.print("Enter name of the course- ");
				                    String cname = sc.nextLine();
				                    System.out.print("Enter strength of the class- ");
				                    int cstrength = sc.nextInt();
				                    sc.nextLine();
				                    admin1.addCourse(cname, cstrength);
				                    break;
				                case 2:
				                    System.out.print("Enter id of the course- ");
				                    int id = sc.nextInt();
				                     
				                    sc.nextLine();
				                    admin1.deleteCourse(id);
				                    break;

				                case 3:
				                	admin1.viewCourses();
				                    break;
				                    
				                case 4:

				                	admin1.viewComplaints();
				                    break;

				                case 5:
				                    System.out.print("Enter complaint- ");
				                    String complaint = sc.nextLine();
				        

				                    System.out.print("Enter new status- ");
				                    String status = sc.nextLine();

				                    admin1.updateComplaintStatus();
				                    break;

				                case 6:
				                    System.out.print("Enter student username- ");
				                    String susername = sc.nextLine();
				                    

				                    System.out.print("Enter password- ");
				                    String spassword = sc.nextLine();

				                    System.out.print("Enter name- ");
				                    String name = sc.nextLine();

				                    System.out.print("Enter contact number- ");
				                    int contact_no = sc.nextInt();
				                    sc.nextLine();

				                    admin1.updateRecords(susername,spassword,name,contact_no);
				                    break;
				                case 7:
				            
				                	admin1.viewRecords();
				                    break;
				                case 8:
				                	System.out.print("Enter subject: ");
				                	String subject = sc.nextLine();

				                	System.out.print("Enter availability: ");
				                	String avail = sc.nextLine();

				                	AssignProfessor p = new AssignProfessor(subject, avail);
				                	p.perform();
				                	break;
				                	
				                case 9:
				                	
				                	scanner.nextLine();
				                	System.out.println("Enter student username.");				                	
				                	String username3 = scanner.nextLine();
				                	System.out.println("Enter the subject");
				                	String Subject = scanner.nextLine();
				                	System.out.println("Enter the student's grade for the subject");
				                	String grade = scanner.nextLine();
				                	System.out.println("Enter no. of credits of subject");
				                	int credits = scanner.nextInt();
				                	
				                	admin1.updateGrade(username3, Subject , grade, credits);
				                	break;
				                	
				                case 10:
				                    System.out.println("Exiting to end the application...");
				                    return;

				                default:
				                    System.out.println("Invalid choice!");
				            }
				        }
				   
				
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
						System.out.println("Full Name:");
						String name = scanner.nextLine();
						System.out.println("Contact Number:");
						long contactno = scanner.nextLong();
						student.createAccount(username, name, contactno);
						
					case 2:
						System.out.println("Enter your username and password");
						System.out.println("Username:");
						username = scanner.nextLine();
						System.out.println("Password:");
						String password1 = scanner.nextLine();
						
						student.getLoginCredentials(username, password1);
						
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
							String password2 = scanner.nextLine();
							
							if(student1.login.verifyPassword(username, password2))
							{
								System.out.println("New Password:");
								String newPassword = scanner.nextLine();
								
								student1.login.changePassword(username, password2, newPassword);
							
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
