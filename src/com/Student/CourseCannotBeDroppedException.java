package com.Student;

public class CourseCannotBeDroppedException extends Exception
{
	CourseCannotBeDroppedException(String msg)
	{
		super(msg);
	}
}
