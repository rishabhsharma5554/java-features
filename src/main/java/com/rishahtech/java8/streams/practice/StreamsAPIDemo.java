package com.rishahtech.java8.streams.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsAPIDemo {

	public static void main(String[] args) {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 75, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
//		employeeList.forEach(System.out::println);
		
		System.out.println("*********************Query 1 : How many male and female employees are there in the organization?");
		Map<String, Long> maleFamaleEmployee = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println(maleFamaleEmployee);
		
		for(Map.Entry<String, Long> e : maleFamaleEmployee.entrySet())
		System.out.println(e.getKey()+ "  --- >   "+e.getValue());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n*********************Query 2 : Print the name of all departments in the organization?");
		
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		System.out.println();
		
		
		List<String> nameAllDepartment = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
		nameAllDepartment.forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n*********************Query 3 : What is the average age of male and female employees?");
	
		Map<String, Double> averageMaleFemale = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
		System.out.println(averageMaleFemale);
		
		for (Map.Entry<String, Double> entry : averageMaleFemale.entrySet()) 
		{
			System.out.println(entry.getValue());
			System.out.println(entry.getKey());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n*********************Query 4 : Get the details of highest paid employee in the organization?");
		Employee highestSalaryEmployee = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
		System.out.println(highestSalaryEmployee);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n*********************Query 5 : Get the names of all employees who have joined after 2015?");
		List<Employee> allEmpJoinedAfter2015 = employeeList.stream().filter(emp -> emp.getYearOfJoining()>2015).collect(Collectors.toList());
		allEmpJoinedAfter2015.forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n*********************Query 6 : Count the number of employees in each department?");
	
		
		Map<String, Long> noOfEmpInDepart = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		for(Map.Entry<String, Long> var : noOfEmpInDepart.entrySet())
		{
			System.out.println(var.getKey() +" - "+var.getValue());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n*********************Query 7 : What is the average salary of each department?");
		Map<String, Double> avgSalaryByDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
		avgSalaryByDepartment.forEach((k,v) -> System.out.println(k+" "+v));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n*********************Query 8 : Get the details of youngest male employee in the product development department?");
		
		Employee youngEmp = employeeList.stream().filter(emp -> emp.getGender().equals("Male") && emp.getDepartment().equals("Product Development")).min(Comparator.comparingInt(Employee::getAge)).get();
		System.out.println(youngEmp);
		
		
		
		
		
		
		
		
		
		System.out.println("\n*********************Query 9 : Who has the most working experience in the organization?");
		
		Employee mostWorkExpEmp = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst().get();
		System.out.println(mostWorkExpEmp);

		
		
		
		
		
		
		
		System.out.println("\n*********************Query 10 : How many male and female employees are there in the sales and marketing team?");
		Map<String, Long> collect = employeeList.stream().filter(emp -> emp.getDepartment().equals("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println(collect);
		
		
		
		
		
		
		
		
		
		System.out.println("\n*********************Query 11 : What is the average salary of male and female employees?");
		Map<String, Double> avgMaleFemale = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgMaleFemale);
	
		
		
		
		
		
		
		
		System.out.println("\n*********************Query 12 : List down the names of all employees in each department?");
		Map<String, List<Employee>> allEmpByDepart = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		for(Map.Entry<String, List<Employee>> map : allEmpByDepart.entrySet())
		{
			System.out.println(map.getKey()+" "+map.getValue());
		}
		
		System.out.println("\n*********************Query 13 : What is the average salary and total salary of the whole organization?");
		Double totalSalary = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getSum();
		Double avgSalary2 = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getAverage();
		Double avgSalary = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		
		System.out.println("Total Salary "+totalSalary);
		System.out.println("Average Salary "+avgSalary2);
		System.out.println("Average Salary "+avgSalary);
		
		System.out.println("\n*********************Query 14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.");
		Map<Boolean, List<Employee>> trueFalseGroup = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
		for(Map.Entry<Boolean, List<Employee>> map : trueFalseGroup.entrySet())
		{
			System.out.println(map.getKey());
			map.getValue().forEach(System.out::println);
		}
		
		/*
		The partitioningBy() method divides the elements into two groups (partitions) based on the provided predicate. 
		In this case, the predicate e -> e.getAge() > 25 checks if an employee's age is greater than 25.

		The result of the collect() operation is a Map<Boolean, List<Employee>> where:

		The key type is Boolean, representing the two possible groups: 
		true for employees older than 25, and false for employees 25 or younger.
			
		The value type is List<Employee>, representing the list of employees in each group.
		So, after executing the code, you will have a map with two entries: 
		one entry with key true and value containing a list of employees older than 25, 
		and another entry with key false and value containing a list of employees 25 or younger.
		*/
		
		System.out.println("\n*********************Query 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?");
		Employee oldestEmp = employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).get();
		System.out.println("Our Oldest Employee \""+oldestEmp.name+"\" belongs to \""+oldestEmp.department+"\"");
		
		
		//get all the females
		System.out.println("nice");
		employeeList.stream().filter(emp -> emp.getGender().equals("Female")).forEach(System.out::println);
		
		System.out.println("xx");
		employeeList.stream().filter(emp -> emp.getGender().equals("Female")).sorted((e1,e2) -> e1.getAge()-e2.getAge()).collect(Collectors.toList()).forEach(System.out::println);;
		
		System.out.println();
		
		
		System.out.println("\n*********************Query 16 : Print the Max Salary Employees from each Deaprtment? ");
		Map<String, Employee> collect2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen( Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),Optional::get)));
//		System.out.println(collect2);
		for(Map.Entry<String, Employee> e : collect2.entrySet())
			System.out.println(e.getKey() + " 	:::::: " + e.getValue().getName() + " " +e.getValue().getSalary());
	}
}
