# **🎓 Student Academic Management System (SAMS)**

A Java-based academic management system that allows students and administrators to manage academic activities efficiently through a centralized platform.

The project follows Object-Oriented Programming principles and uses JDBC for database connectivity with MySQL.

---

## **🚀 Features**

### **👨‍🎓 Student Module**

* Student Registration  
* Secure Login Authentication  
* View Courses  
* Course Registration  
* Course Dropping  
* View Academic Schedule  
* View Course Details  
* SGPA Calculation  
* CGPA Calculation  
* Course Feedback Submission  
* Complaint Registration  
* Complaint Status Tracking

### **👨‍💼 Administrator Module**

* Add Courses  
* Delete Courses  
* Update Student Records  
* View Academic Records  
* Manage Complaints  
* Update Complaint Status

---

## **🛠️ Technologies Used**

| Technology | Purpose |
| ----- | ----- |
| Java | Application Development |
| JDBC | Database Connectivity |
| MySQL | Data Storage |
| Eclipse IDE | Development Environment |
| Git | Version Control |
| GitHub | Repository Hosting |

---

## **🏗️ System Architecture**

┌─────────────────────┐  
│   User Interface    │  
└──────────┬──────────┘  
          │  
          ▼  
┌─────────────────────┐  
│ Business Logic Layer│  
└──────────┬──────────┘  
          │  
          ▼  
┌─────────────────────┐  
│ JDBC Data Layer     │  
└──────────┬──────────┘  
          │  
          ▼  
┌─────────────────────┐  
│    MySQL Database   │  
└─────────────────────┘  
---

## **📂 Project Structure**

src/  
│  
├── Login.java  
├── StudentLogin.java  
├── AdminLogin.java  
│  
├── Student.java  
├── StudentCourses.java  
├── StudentSchedule.java  
├── StudentAcademicProgress.java  
├── StudentRegisterCourses.java  
├── StudentDropCourses.java  
├── StudentCourseFeedback.java  
├── StudentComplaints.java  
│  
├── AdminDAO.java  
├── AdminTasks.java  
├── StudentRecord.java  
│  
├── DBConnection.java  
│  
└── Custom Exceptions  
---

## **📊 Main Functionalities**

### **Authentication**

* Account Creation  
* Login Verification  
* Password Validation

### **Academic Management**

* Course Registration  
* Course Withdrawal  
* Timetable Management  
* Academic Performance Tracking

### **Feedback & Complaints**

* Submit Course Feedback  
* Raise Complaints  
* Track Complaint Resolution

---

## **🗄️ Database Tables**

### **logincredentials**

username  
password  
name  
contact\_no

### **coursetracker\_studentid**

course  
credits  
grade  
status

### **academicperformance\_studentid**

semester  
sgpa  
credits

### **complaints**

complaint\_id  
username  
complaint  
status

### **feedback**

username  
course  
rating  
comments  
---

## **⚙️ Installation**

### **Clone Repository**

git clone https://github.com/\<your-username\>/\<repository-name\>.git

### **Open Project**

Import project into Eclipse IDE.

### **Configure Database**

Create a MySQL database:

CREATE DATABASE StudentLoginCredentials;

Update database credentials in code:

DriverManager.getConnection(  
   "jdbc:mysql://localhost:3306/StudentLoginCredentials",  
   "root",  
   "your\_password"  
);

### **Add JDBC Driver**

Add MySQL Connector/J to project build path.

### **Run Application**

Run:

ApplicationUser.java  
---

## **📖 Object-Oriented Concepts Used**

### **Encapsulation**

* Private fields with controlled access.

### **Inheritance**

* Shared functionality across modules.

### **Abstraction**

* Login interface implementation.

### **Polymorphism**

* Method overriding and interface implementation.

### **Exception Handling**

Custom exceptions:

* AccountAlreadyExistsException  
* CourseCannotBeDroppedException  
* CourseNotFoundException  
* DepartmentNotFoundException  
* FeedbackNotAcceptedException  
* FileCannotBeAccessedException  
* IllegalGradeTypeException  
* InvalidComplaintStatusException  
* InvalidEmailIDException  
* UserNotFoundException

---

## **🔮 Future Enhancements**

* Java Swing / JavaFX GUI  
* Attendance Management  
* Placement Management  
* Hostel Management  
* Email Notifications  
* OTP Authentication  
* Mobile Application  
* REST API Integration  
* Cloud Deployment

---

## **📸 Screenshots**

Add screenshots of:

* Login Screen  
* Student Dashboard  
* Course Registration  
* Academic Progress  
* Complaint Management

Example:

\!\[Login\](screenshots/login.png)  
---

## **🧪 Testing**

The application has been tested for:

* User Authentication  
* Course Registration  
* Course Dropping  
* GPA Calculation  
* Complaint Handling  
* Database Operations

---

## **👤 Author**

**Hema Akshita**

B.Tech Student | Artificial Intelligence

---

## **⭐ Contributions**

Contributions, suggestions, and improvements are welcome.

If you found this project useful, consider giving it a ⭐ on GitHub.

