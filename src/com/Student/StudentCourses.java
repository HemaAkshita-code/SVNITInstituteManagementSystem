package com.Student;

import java.util.*;

public class StudentCourses 
{	
	public HashMap<Integer, List<String>> UArtificialIntelligence = new HashMap<>(Map.ofEntries(
            Map.entry(1, List.of("BEEE", "IOP", "Maths", "IOCS")),
            Map.entry(2, List.of("DSA", "OOP", "DELD", "LAS")),
            Map.entry(3, List.of("Biology", "Geography")),
            Map.entry(4, List.of("Geology", "Astronomy")),
            Map.entry(5, List.of("EEE", "C", "Maths")),
            Map.entry(6, List.of("Physics", "Chemistry")),
            Map.entry(7, List.of("Biology", "Geography")),
            Map.entry(8, List.of("Geology", "Astronomy"))
        ));
	
	public HashMap<Integer, List<String>> UElectricalEngineering = new HashMap<>(Map.ofEntries(
		    Map.entry(1, List.of("EEE", "Ck", "Maths")),
            Map.entry(2, List.of("Physics", "Chemistry")),
            Map.entry(3, List.of("Biology", "Geography")),
            Map.entry(4, List.of("Geology", "Astronomy")),
            Map.entry(5, List.of("EEE", "C", "Maths")),
            Map.entry(6, List.of("Physics", "Chemistry")),
            Map.entry(7, List.of("Biology", "Geography")),
            Map.entry(8, List.of("Geology", "Astronomy"))
        ));
	
	public HashMap<Integer, List<String>> UComputerScience = new HashMap<>(Map.ofEntries(
            Map.entry(1, List.of("EEE", "C", "Maths")),
            Map.entry(2, List.of("Physics", "Chemistry")),
            Map.entry(3, List.of("Biology", "Geography")),
            Map.entry(4, List.of("Geology", "Astronomy")),
            Map.entry(5, List.of("EEE", "C", "Maths")),
            Map.entry(6, List.of("Physics", "Chemistry")),
            Map.entry(7, List.of("Biology", "Geography")),
            Map.entry(8, List.of("Geology", "Astronomy"))
        ));
	
	public HashMap<Integer, List<String>> UMechanicalEngineering = new HashMap<>(Map.ofEntries(
		    Map.entry(1, List.of("EEE", "Ck", "Maths")),
            Map.entry(2, List.of("Physics", "Chemistry")),
            Map.entry(3, List.of("Biology", "Geography")),
            Map.entry(4, List.of("Geology", "Astronomy")),
            Map.entry(5, List.of("EEE", "C", "Maths")),
            Map.entry(6, List.of("Physics", "Chemistry")),
            Map.entry(7, List.of("Biology", "Geography")),
            Map.entry(8, List.of("Geology", "Astronomy"))
        ));
	
	public HashMap<Integer, List<String>> UChemicalEngineering = new HashMap<>(Map.ofEntries(
            Map.entry(1, List.of("EEE", "C", "Maths")),
            Map.entry(2, List.of("Physics", "Chemistry")),
            Map.entry(3, List.of("Biology", "Geography")),
            Map.entry(4, List.of("Geology", "Astronomy")),
            Map.entry(5, List.of("EEE", "C", "Maths")),
            Map.entry(6, List.of("Physics", "Chemistry")),
            Map.entry(7, List.of("Biology", "Geography")),
            Map.entry(8, List.of("Geology", "Astronomy"))
        ));
	
	public HashMap<Integer, List<String>> UVLSI = new HashMap<>(Map.ofEntries(
		    Map.entry(1, List.of("EEE", "Ck", "Maths")),
            Map.entry(2, List.of("Physics", "Chemistry")),
            Map.entry(3, List.of("Biology", "Geography")),
            Map.entry(4, List.of("Geology", "Astronomy")),
            Map.entry(5, List.of("EEE", "C", "Maths")),
            Map.entry(6, List.of("Physics", "Chemistry")),
            Map.entry(7, List.of("Biology", "Geography")),
            Map.entry(8, List.of("Geology", "Astronomy"))
        ));
	
	public HashMap<Integer, List<String>> UCivilEngineering = new HashMap<>(Map.ofEntries(
            Map.entry(1, List.of("EEE", "C", "Maths")),
            Map.entry(2, List.of("Physics", "Chemistry")),
            Map.entry(3, List.of("Biology", "Geography")),
            Map.entry(4, List.of("Geology", "Astronomy")),
            Map.entry(5, List.of("EEE", "C", "Maths")),
            Map.entry(6, List.of("Physics", "Chemistry")),
            Map.entry(7, List.of("Biology", "Geography")),
            Map.entry(8, List.of("Geology", "Astronomy"))
        ));
	
	public HashMap<Integer, List<String>> UElectronicsEngineering = new HashMap<>(Map.ofEntries(
		    Map.entry(1, List.of("EEE", "Ck", "Maths")),
            Map.entry(2, List.of("Physics", "Chemistry")),
            Map.entry(3, List.of("Biology", "Geography")),
            Map.entry(4, List.of("Geology", "Astronomy")),
            Map.entry(5, List.of("EEE", "C", "Maths")),
            Map.entry(6, List.of("Physics", "Chemistry")),
            Map.entry(7, List.of("Biology", "Geography")),
            Map.entry(8, List.of("Geology", "Astronomy"))
        ));
	
	Map<String, HashMap<Integer, List<String>>> UDepartments =
		    new HashMap<>(Map.of(
		        "ai", UArtificialIntelligence,
		        "ee", UElectricalEngineering,
		        "ec", UElectronicsEngineering,
		        "cs", UComputerScience,
		        "me", UMechanicalEngineering,
		        "ch", UChemicalEngineering,
		        "ce", UCivilEngineering,
		        "ev", UVLSI
		    ));
	
	String userid = "null";
	String department;
	String graduationStatus;
	int currentSem;
	
	StudentCourses(String username, int currentSem)
	{
		userid = username;
		this.currentSem = currentSem;
		this.department = userid.substring(3,5);
		this.graduationStatus = userid.substring(0,1);
	}
	
	StudentCourses()
	{
		
	}

	public void viewCourses()
	{
		try
		{
			if(userid.equals("null"))
			{
				throw new InvalidEmailIDException("Invalid Email Id! please try again.");
			}
			
			if(UDepartments.containsKey(department))
			{
				for(String course : UDepartments.get(department).get(currentSem))
				{
					System.out.println("-" + course);
				}
			}
			else
			{
				throw new DepartmentNotFoundException("The department you are requesting for is not available.");
			}
		}
		catch(DepartmentNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch(InvalidEmailIDException ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}	
	
}

