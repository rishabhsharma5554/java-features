package com.rishahtech.java8.streams.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PracticeQuestionsWithAnswers {
    private final static ArrayList<Employee> employeeList = StreamsAPIDemo.initalizeEmployees();

    public static void main(String[] args) {
        System.out.println("Query 1 : How many male and female employees are there in the organization?");
        Map<String,Long> maleFamaleEmployee = employeeList.parallelStream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println(maleFamaleEmployee);
        System.out.println();

        System.out.println("Query 2 : Print the name of all departments in the organization?");
        employeeList.parallelStream()
                .map(Employee::getDepartment)
                .distinct()
                .forEachOrdered(System.out::println);
        System.out.println();

        System.out.println("Query 3 : What is the average age of male and female employees?");
        Map<String,Double> maleFeamleAverageAge = employeeList.parallelStream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge)));
        System.out.println(maleFeamleAverageAge);
        System.out.println();

        System.out.println("Query 4 : Get the details of highest paid employee in the organization?");
        Employee obj = employeeList.parallelStream()
                .max(Comparator.comparingDouble(Employee::getSalary)).get();
        System.out.println(obj);
        System.out.println();

        System.out.println("Query 5 : Get the names of all employees who have joined after 2015?");
        employeeList.parallelStream()
                .filter(emp -> emp.getYearOfJoining()>2015).forEach(System.out::println);
        System.out.println();

        System.out.println("Query 6 : Count the number of employees in each department?");
        Map<String,Long> noOfEmpByDepartment = employeeList.parallelStream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(noOfEmpByDepartment);
        System.out.println();

        System.out.println("Query 7 : What is the average salary of each department?");
        Map<String,Double> avgSalaryByDepartment =  employeeList.parallelStream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryByDepartment);
        System.out.println();

        System.out.println("Query 8 : Get the details of youngest male employee in the product development department?");
        employeeList.parallelStream()
                .filter(emp -> emp.getDepartment().equals("Product Development") && emp.getGender().equalsIgnoreCase("male"))
                .min(Comparator.comparingInt(Employee::getAge))
                .ifPresent(System.out::println);
        System.out.println();

        System.out.println("Query 9 : Who has the most working experience in the organization?");
        employeeList.parallelStream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining))
                .findFirst()
                .ifPresent(System.out::println);

        employeeList.parallelStream()
                .min(Comparator.comparingInt(Employee::getYearOfJoining))
                .ifPresent(System.out::println);
        System.out.println();

        System.out.println("Query 10 : How many male and female employees are there in the sales and marketing team?");
        employeeList.parallelStream()
                .filter(emp -> emp.getDepartment().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));

        System.out.println("Query 11 : What is the average salary of male and female employees?");
        Map<String,Double> avgSalaryOfMaleFemale= employeeList.parallelStream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryOfMaleFemale);
        System.out.println();

        System.out.println("Query 12 : List down the names of all employees in each department?");
        Map<String, List<Employee>> empByDepartment = employeeList.parallelStream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
//        for(Map.Entry<String,List<Employee>> emp :  empByDepartment.entrySet()){
//            System.out.println(emp.getKey());
//            for(Employee employee : emp.getValue()){
//                System.out.print(employee.getName()+", ");
//            }
//        }
//        }
        System.out.println(empByDepartment);
        System.out.println();

        System.out.println("Query 13 : What is the average salary and total salary of the whole organization?");
        Double avgSalary = employeeList.parallelStream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

        Double avgSalary2 = employeeList.parallelStream()
                .collect(Collectors.summarizingDouble(Employee::getSalary))
                .getAverage();

        Double totalSalary = employeeList.parallelStream()
                .collect(Collectors.summarizingDouble(Employee::getSalary)).getSum();

        System.out.println("Total Salary "+totalSalary);
        System.out.println("Average Salary "+avgSalary);
        System.out.println("Average Salary "+avgSalary2);
        System.out.println();


        System.out.println("Query 14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.");
        Map<Boolean, List<Employee>> seperateEmployeeBy25 = employeeList.parallelStream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 25));
        System.out.println(seperateEmployeeBy25);
        System.out.println();

        System.out.println("Query 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?");
        Employee oldestEmployee = employeeList.stream()
                .min(Comparator.comparingInt(Employee::getYearOfJoining))
                .get();
        System.out.println("Oldest Employee "+oldestEmployee.getName()+" & Department "+oldestEmployee.getDepartment());
        System.out.println();

        System.out.println("Query 16 : Print the Max Salary Employees from each Department?");
        Map<String, Optional<Employee>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(collect);
        System.out.println();

        System.out.println("Query 17 : Get all the females in the sales department and print their names?");
        employeeList.stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase("Sales And Marketing") && emp.getGender().equalsIgnoreCase("female"))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Query 18 : Find 2nd highest salary in the organization?");
        Employee sortedOnSalary = employeeList.parallelStream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(sortedOnSalary);
        System.out.println();

        System.out.println("Query 19 : Find 2nd highest salary in the female employees?");
        employeeList.parallelStream()
                .filter(emp -> emp.getGender().equalsIgnoreCase("female"))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .stream()
                .toList()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("FlatMap Q1 : Split all employee names into individual words and collect as a flat list?");
        System.out.println("FlatMap Q2 : Get all distinct words from department names?");
        System.out.println("FlatMap Q3 : Get all distinct characters from all employee names (lowercase)?");
        System.out.println("FlatMap Q4 : For each department, get a flat list of (department - employeeName) strings?");
        System.out.println("FlatMap Q5 : Given a list of lists of employees (grouped by gender), flatten into a single list sorted by salary?");
        System.out.println("FlatMap Q6 : For each employee, generate multiple attributes as a flat stream (name, department, salary) and collect?");
        System.out.println("FlatMap Q7 : Get employees whose name contains more than one word and collect all first names?");

        // ========================= Internet Interview Questions =========================
        System.out.println("IQ 1 : Given a list of integers, separate odd and even numbers?");
        System.out.println("IQ 2 : How do you remove duplicate elements from a list using Java 8 streams?");
        System.out.println("IQ 3 : How do you find frequency of each character in a string?");
        System.out.println("IQ 4 : How do you find frequency of each element in an array or a list?");
        System.out.println("IQ 5 : How do you sort the given list of decimals in reverse order?");
        System.out.println("IQ 6 : Given a list of strings, join them with '[' as prefix, ']' as suffix and ',' as delimiter?");
        System.out.println("IQ 7 : From the given list of integers, print the numbers which are multiples of 5?");
        System.out.println("IQ 8 : Given a list of integers, find maximum and minimum of those numbers?");
        System.out.println("IQ 9 : How do you merge two unsorted arrays into single sorted array?");
        System.out.println("IQ 10 : How do you merge two unsorted arrays into single sorted array without duplicates?");
        System.out.println("IQ 11 : How do you get three maximum numbers and three minimum numbers from the given list of integers?");
        System.out.println("IQ 12 : Check if two strings are anagrams or not?");
        System.out.println("IQ 13 : Find sum of all digits of a number?");
        System.out.println("IQ 14 : Find second largest number in an integer array?");
        System.out.println("IQ 15 : Given a list of strings, sort them according to increasing order of their length?");
        System.out.println("IQ 16 : Given an integer array, find sum and average of all elements?");
        System.out.println("IQ 17 : How do you find common elements between two arrays?");
        System.out.println("IQ 18 : Reverse each word of a string using Java 8 streams?");
        System.out.println("IQ 19 : How do you find sum of first 10 natural numbers?");
        System.out.println("IQ 20 : Reverse an integer array?");
        System.out.println("IQ 21 : Print first 10 even numbers?");
        System.out.println("IQ 22 : How do you find the most repeated element in an array?");
        System.out.println("IQ 23 : Palindrome program using Java 8 streams?");
        System.out.println("IQ 24 : Given a list of strings, find out those which start with a number?");
        System.out.println("IQ 25 : How do you extract duplicate elements from an array?");
        System.out.println("IQ 26 : Print duplicate characters in a string?");
        System.out.println("IQ 27 : Find first repeated character in a string?");
        System.out.println("IQ 28 : Find first non-repeated character in a string?");
        System.out.println("IQ 29 : Fibonacci series using Java 8 streams?");
        System.out.println("IQ 30 : First 10 odd numbers using Java 8 streams?");
        System.out.println("IQ 31 : How do you get last element of an array?");
        System.out.println("IQ 32 : Find the age of a person in years given the birthday (using LocalDate)?");

        // ========================= Employee-Based (GitHub/Medium 2025) =========================
        System.out.println("EQ 1 : Find list of employees whose name starts with alphabet 'A'?");
        System.out.println("EQ 2 : Find the total count of employees using stream?");
        System.out.println("EQ 3 : Find the max age of employees?");
        System.out.println("EQ 4 : Find the list of employees whose age is less than 30?");
        System.out.println("EQ 5 : Find the list of employees whose age is between 26 and 31?");
        System.out.println("EQ 6 : Find the department which has the maximum number of employees?");
        System.out.println("EQ 7 : Find the employee who has the second lowest salary?");
        System.out.println("EQ 8 : Sort employees by their salary in ascending order?");
        System.out.println("EQ 9 : Find the highest salary in each department?");
        System.out.println("EQ 10 : Find the average salary across the entire organization?");
        System.out.println("EQ 11 : Find all employees who joined in a specific year (e.g., 2015)?");
        System.out.println("EQ 12 : Group employees by gender and get the list of names in each group?");
        System.out.println("EQ 13 : Find the employee with the longest name?");
        System.out.println("EQ 14 : Get a comma-separated string of all employee names?");
        System.out.println("EQ 15 : Find the department with the highest average salary?");
        System.out.println("EQ 16 : Check if all employees are older than 20 using allMatch?");
        System.out.println("EQ 17 : Check if any employee salary is greater than 30000 using anyMatch?");
        System.out.println("EQ 18 : Find the total salary expenditure of the organization using reduce?");
        System.out.println("EQ 19 : Find the Nth highest salary in the organization (e.g., 3rd highest)?");
        System.out.println("EQ 20 : Get a Map of department name to list of employee names (not Employee objects)?");

        // ========================= Tricky / Advanced Stream Questions =========================
        System.out.println("AQ 1 : Given a list of integers, find all prime numbers using streams?");
        System.out.println("AQ 2 : Convert a list of strings to a map where key is the string and value is its length?");
        System.out.println("AQ 3 : Find the longest string in a list of strings?");
        System.out.println("AQ 4 : Count the number of words in a sentence using streams?");
        System.out.println("AQ 5 : Given a list of sentences, find the total word count across all sentences?");
        System.out.println("AQ 6 : Find all elements that appear more than once in a list?");
        System.out.println("AQ 7 : Given a list of integers, find the product of all elements using reduce?");
        System.out.println("AQ 8 : Convert a list of strings to uppercase and collect into a list?");
        System.out.println("AQ 9 : Find the kth largest element in an unsorted list?");
        System.out.println("AQ 10 : Implement a custom collector to concatenate strings with a delimiter?");
        System.out.println("AQ 11 : How to get a slice of a stream (skip first N and limit to M)?");
        System.out.println("AQ 12 : How to reverse elements of a parallel stream?");
        System.out.println("AQ 13 : Find duplicate elements in a stream?");
        System.out.println("AQ 14 : Count occurrence of a given character in a string using Stream API?");
        System.out.println("AQ 15 : Given a map, sort it by values using streams?");

        // ========================= From Codebase (missing questions) =========================
        System.out.println("CB 1 : Filter all even numbers from an int array using streams? (begineer/EvenNumbers)");
        System.out.println("CB 2 : Convert a list of strings to a list of characters using flatMap? (begineer/StringsToCharacter)");
        System.out.println("CB 3 : Sum all integer values in a list using streams? (begineer/SumAllIntValues)");
        System.out.println("CB 4 : Find the longest word in a sentence using streams? (begineer/LongestWordInSentence)");
        System.out.println("CB 5 : Square each number in a list and convert between list and array? (Deloitte/SquareOfNumber)");
        System.out.println("CB 6 : Convert a string to alternate uppercase and lowercase characters? (Newgen/AlternateCharacter)");
        System.out.println("CB 7 : Given a date string, print the day of the week using LocalDate? (Newgen/DataProblem)");
        System.out.println("CB 8 : Parse a date-time string and extract minute and month? (Newgen/DataProblem)");
        System.out.println("CB 9 : From a list of Employee objects, create a list with only names using streams? (Newgen/EmployeeNamesUsingStreams)");
        System.out.println("CB 10 : Reverse each word in a sentence? (Newgen/ReverseStringInSentence)");
        System.out.println("CB 11 : Count frequency of each character in a string using HashMap? (Newgen/StringProblem)");
        System.out.println("CB 12 : Demonstrate Predicate and BiPredicate functional interfaces? (Newgen/PredicateReturnTrueFalse)");
        System.out.println("CB 13 : Print characters occurring an even number of times with their frequency using streams? (globant/MyCode)");
        System.out.println("CB 14 : Merge two sorted arrays into one sorted array using two-pointer approach? (globant/SortedArray)");

        // ========================= Company Specific Questions =========================
        System.out.println("EPAM 1 : Fetch all employees whose salary is greater than 50000 using Stream API?");
    }
}