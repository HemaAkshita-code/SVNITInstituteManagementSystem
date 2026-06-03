package com.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentServices 
{
	static int currentYear = 1;
	static int currentSem = 1;
			
	 public static int getSemester(String username) 
	 {

		 LocalDate today = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
	        
	        String formattedDate = today.format(formatter);
	        
	        currentYear = Integer.parseInt(formattedDate.substring(3)) - Integer.parseInt(username.substring(1,3));
	                    
	        if(Integer.parseInt(formattedDate.substring(0,2)) < 6)
	        {
	            currentSem = currentYear*2;
	        }
	        else
	        {
	        		currentSem = (currentYear*2) - 1;
	        }
	                    
	        return currentSem;
	 }
}
