package com.admin;

public class AssignProfessor implements AdminTasks {

    String subject;
    String available;

    public AssignProfessor(String subject, String available) {
        this.subject = subject;
        this.available = available;
    }

    public void perform() {
        System.out.println("===== Professor Assignment =====");

        if (subject.equalsIgnoreCase("JAVA") && available.equalsIgnoreCase("yes")) {
            System.out.println("Professor Dr.Praveen Kumar of subject "+subject+" assigned successfully!");
        } else {
            System.out.println("Assignment failed!");
        }
    }
}
