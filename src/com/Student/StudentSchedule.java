package com.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StudentSchedule 
{
	
	Map<String, List<String>> UArtificialIntelligenceSchedule1A = new HashMap<>(Map.ofEntries(
            Map.entry("Mon", List.of("  MA105  ", "  AI101  ", "  AI105  ", "  AI103  ", "  L", "    -    ", "    -    ", "    -    ", "    -    ")),
            Map.entry("Tue", List.of("    -    ", "  MA105  ", "  AI103  ", "  HS110  ", "  U", "    -    ", "    -    ", "AI103(P1)", "AI103(P1)")),
            Map.entry("Wed", List.of("  AI101  ", "  AI105  ", "  AI103  ", "  HS110  ", "  N", "AI103(P2)", "AI103(P2)", "AI105(P2)", "AI105(P2)")),
            Map.entry("Thu", List.of("  HS110  ", "    -    ", "  MA105  ", "  AI105  ", "  C", "    -    ", "    -    ", "AI105(P1)", "AI105(P1)")),
            Map.entry("Fri", List.of("    -    ", "  MA105  ", "  AI103  ", "  HS110  ", "  H", "    -    ", "    -    ", "    -    ", "    -    "))
        ));
	
	Map<String, List<String>> UArtificialIntelligenceDetails1A = new HashMap<>(Map.ofEntries(
            Map.entry("BEEE   ", List.of("      TA101        ", "AI105", "DoAI106", "4")),
            Map.entry("IOP    ", List.of("      TA102        ", "AI103", "DoAI106", "4")),
            Map.entry("Maths  ", List.of("      TA106        ", "MA105", "DoAI106", "4")),
            Map.entry("IOCS   ", List.of("      TA103        ", "AI101", "DoAI106", "4")),
            Map.entry("English", List.of("      TA105        ", "HS110", "DoAI106", "4"))
        ));
	
	Map<String, List<String>> UArtificialIntelligenceSchedule2A = new HashMap<>(Map.ofEntries(
			Map.entry("Mon", List.of("  MA106  ", "  AI106  ", "  AI102  ", "    -    ", "  L", "AI102(p1)", "AI102(p1)", "  EG110  ", "    -    ")),
            Map.entry("Tue", List.of("  AI106  ", "  MA106  ", "  HS120  ", "  AI102  ", "  U", "AI106(p2)", "AI106(p2)", "AI106(P1)", "AI106(P1)")),
            Map.entry("Wed", List.of("  AI102  ", "  EC106  ", "  EG110  ", "  HS120  ", "  N", "    -    ","   AI106  ", "  EC106  ", "  EG110  ")),
            Map.entry("Thu", List.of("EG110(p2)", "EG110(p2)", "    -    ", "  MA106  ", "  C", "EC106(p2)", "EC106(p2)", "AI105(P1)", "AI105(P1)")),
            Map.entry("Fri", List.of("  MA106  ", "  EC106  ", "AI102(p2)", "AI102(p2)", "  H", "EG110(p1)", "EG110(p1)", "EC106(p1)", "EC106(p1)"))
        ));
	
	Map<String, List<String>> UArtificialIntelligenceDetails2A = new HashMap<>(Map.ofEntries(
			Map.entry("DS  ", List.of("Dr. Rahul Shrivastava ", "AI105", "DoAI106", "4")),
            Map.entry("OOP ", List.of("Dr. Praveen kumar     ", "AI103", "DoAI106", "4")),
            Map.entry("IVS ", List.of("Humanities Department ", "HS120", "DoAI106", "3")),
            Map.entry("EEE ", List.of("Mech/ Civil Department", "AI101", "DoAI106", "4")),
            Map.entry("LAS ", List.of("Mathematics Department", "MA106", "DoAI106", "4")),
            Map.entry("DELD", List.of("EE / EC Department    ", "EC106", "DoAI106", "4"))
        ));
	
	Map<Integer, List<Map<String, List<String>>>> UArtificialIntelligenceSchedule = new HashMap<>(Map.ofEntries(
            Map.entry(1, List.of(UArtificialIntelligenceSchedule1A)),
            Map.entry(2, List.of(UArtificialIntelligenceSchedule2A))
//          Map.entry(3, List.of(UArtificialIntelligenceSchedule3A, UArtificialIntelligenceSchedule3B)),
//          Map.entry(4, List.of(UArtificialIntelligenceSchedule4A, UArtificialIntelligenceSchedule4B))
        ));
	
	Map<Integer, List<Map<String, List<String>>>> UArtificialIntelligenceDetails = new HashMap<>(Map.ofEntries(
            Map.entry(1, List.of(UArtificialIntelligenceDetails1A)),
            Map.entry(2, List.of(UArtificialIntelligenceDetails2A))
//          Map.entry(3, List.of(UArtificialIntelligenceSchedule3A, UArtificialIntelligenceSchedule3B)),
//          Map.entry(4, List.of(UArtificialIntelligenceSchedule4A, UArtificialIntelligenceSchedule4B))
        ));
	
	Map<Integer, List<Map<String, List<String>>>> UElectricalEngineeringSchedule = new HashMap<>(Map.ofEntries(
//			Map.entry(1, List.of(UElectricalEngineeringSchedule1A)),
//            Map.entry(2, List.of(UElectricalEngineeringSchedule2A))
//            Map.entry(3, List.of("Biology", "Geography")),
//            Map.entry(4, List.of("Geology", "Astronomy"))
        ));
	
	Map<Integer, List<Map<String, List<String>>>> UElectronicsEngineeringSchedule = new HashMap<>(Map.ofEntries(
//            Map.entry(1, List.of(UElectronicsEngineeringSchedule1A)),
//            Map.entry(2, List.of(UElectronicsEngineeringSchedule2A)),
//            Map.entry(3, List.of(UElectronicsEngineeringSchedule3A)),
//            Map.entry(4, List.of(UElectronicsEngineeringSchedule4A))
        ));
	
	Map<Integer, List<Map<String, List<String>>>> UComputerScienceSchedule = new HashMap<>(Map.ofEntries(
//            Map.entry(1, List.of("EEE", "C", "Maths")),
//            Map.entry(2, List.of("Physics", "Chemistry")),
//            Map.entry(3, List.of("Biology", "Geography")),
//            Map.entry(4, List.of("Geology", "Astronomy"))
        ));
	
	Map<Integer, List<Map<String, List<String>>>> UMechanicalEngineeringSchedule = new HashMap<>(Map.ofEntries(
//            Map.entry(1, List.of("EEE", "C", "Maths")),
//            Map.entry(2, List.of("Physics", "Chemistry")),
//            Map.entry(3, List.of("Biology", "Geography")),
//            Map.entry(4, List.of("Geology", "Astronomy"))
        ));
	
	Map<Integer, List<Map<String, List<String>>>> UChemicalEngineeringSchedule = new HashMap<>(Map.ofEntries(
//            Map.entry(1, List.of("EEE", "C", "Maths")),
//            Map.entry(2, List.of("Physics", "Chemistry")),
//            Map.entry(3, List.of("Biology", "Geography")),
//            Map.entry(4, List.of("Geology", "Astronomy"))
        ));
	
	Map<Integer, List<Map<String, List<String>>>> UCivilEngineeringSchedule = new HashMap<>(Map.ofEntries(
//            Map.entry(1, List.of("EEE", "C", "Maths")),
//            Map.entry(2, List.of("Physics", "Chemistry")),
//            Map.entry(3, List.of("Biology", "Geography")),
//            Map.entry(4, List.of("Geology", "Astronomy"))
        ));
	
	Map<Integer, List<Map<String, List<String>>>> UVLSISchedule = new HashMap<>(Map.ofEntries(
//            Map.entry(1, List.of("EEE", "C", "Maths")),
//            Map.entry(2, List.of("Physics", "Chemistry")),
//            Map.entry(3, List.of("Biology", "Geography")),
//            Map.entry(4, List.of("Geology", "Astronomy"))
        ));
	
	Map<String, Map<Integer, List<Map<String, List<String>>>>> UDepartmentsSchedule = new HashMap<>(Map.ofEntries(
		    		Map.entry("ai", UArtificialIntelligenceSchedule),
		    		Map.entry("ee", UElectricalEngineeringSchedule),
		    		Map.entry("ec", UElectronicsEngineeringSchedule),
		    		Map.entry("cs", UComputerScienceSchedule),
				Map.entry("me", UMechanicalEngineeringSchedule),
				Map.entry("ch", UChemicalEngineeringSchedule),
				Map.entry("ce", UCivilEngineeringSchedule),
				Map.entry("ev", UVLSISchedule)
		    ));
	
	Map<String, Map<Integer, List<Map<String, List<String>>>>> UDepartmentsDetails = new HashMap<>(Map.ofEntries(
    		Map.entry("ai", UArtificialIntelligenceDetails)
//    		Map.entry("ee", UElectricalEngineeringDetails),
//    		Map.entry("ec", UElectronicsEngineeringDetails),
//    		Map.entry("cs", UComputerScienceDetails),
//		Map.entry("me", UMechanicalEngineeringDetails),
//		Map.entry("ch", UChemicalEngineeringDetails),
//		Map.entry("ce", UCivilEngineeringDetails),
//		Map.entry("ev", UVLSIDetails)
    ));

	String dept;
	int currentSem;
	
	public StudentSchedule(String dept, int currentSem) 
	{
		this.dept = dept;
		this.currentSem = currentSem;
	}
	
	public void viewSchedule()
	{
		String dayDeterminer = null;
		
		System.out.println("\t\t" + "8:30 - 9:20\t" + "9:30 - 10:20\t" + "10:30 - 11:20\t" + "11:30 - 12:20\t" + " " + "\t2:00 - 2:50\t"  + "3:00 - 3:50\t"  + "4:00 - 4:50\t"  + "5:00 - 5:50");

		for(int i = 0; i < 5; i++)
		{
			switch (i)
			{
				case 0:
					dayDeterminer = "Mon";
					break;
				case 1:
					dayDeterminer = "Tue";
					break;
				case 2:
					dayDeterminer = "Wed";
					break;
				case 3:
					dayDeterminer = "Thu";
					break;
				case 4:
					dayDeterminer = "Fri";
					break;
			}
			
			System.out.print("\t" + dayDeterminer + "\t");
			for(String sub : UDepartmentsSchedule.get(dept).get(currentSem).get(0).get(dayDeterminer))
			{
				System.out.print(sub + "\t");
			}
			System.out.println();
			
		}
		
		System.out.println("\n");
		viewDetails();
	}
	
	void viewDetails()
	{
		System.out.println("\tCourse\t" + "\tInstructor\t" + "     CourseID     "+ "Venue\t" + "    Credits");
		for (Map.Entry<String, List<String>> i : UDepartmentsDetails.get(dept).get(currentSem).get(0).entrySet())
		{
			System.out.print("        " + i.getKey() + "      ");
			for(String detail : i.getValue())
			{
				System.out.print(detail+"      ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	

}
