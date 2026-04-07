package com.Student;

import java.util.Scanner;
import java.util.Calendar;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.File;

public class StudentComplaints 
{
	Scanner scanner = new Scanner(System.in);
	
	protected String status = "pending";  //only admin can change
	String complaintInput = null;
	
	public void raiseComplaint()
	{
		System.out.println("Write your complaint:");
		complaintInput = scanner.nextLine();
	
		
		BufferedOutputStream bos = null;
		Calendar cal=Calendar.getInstance();
		try 
		{
			bos = new BufferedOutputStream(new FileOutputStream("D://StudentComplaints.txt", true));
			bos.write(complaintInput.getBytes());
			bos.write(("\n" + cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.YEAR) + "\n\n").getBytes());
			System.out.println("Complaint registered successfully!");
			
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
	
	public File getComplaint()
	{
		File file = null;
		
		try
		{
			file = new File("D://StudentComplaints.txt");
		}
		catch (NullPointerException e)
		{
			e.printStackTrace();
		}
		
		return file;
	}
	
	public boolean complaintStatus()
	{
		try
		{
			if(status.equals("resolved"))
			{
				return true;
			}
			else if(!(status.equals("pending")))
			{
				throw new InvalidComplaintStatusException("The status is invalid");
			}
		}
		catch(InvalidComplaintStatusException e)
		{
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
}


