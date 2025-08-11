package com.rishahtech.java8.lamda.practice;

import java.util.ArrayList;
import java.util.Collections;

public class Example7_Collection_Employee {
    public static void main(String[] args) {
        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(new Employee(100, "Rishabh"));
        empList.add(new Employee(54, "Madhu"));
        empList.add(new Employee(5, "Mohit"));
        empList.add(new Employee(64, "Satya"));
        empList.add(new Employee(23, "Prachi"));
        empList.add(new Employee(876, "Lucky"));

        Collections.sort(empList, (e1, e2) -> e2.empNo - e1.empNo);
        System.out.println(empList);

        //Sort on the basis of Employee Name
        Collections.sort(empList, (e1, e2) -> e1.empName.compareTo(e2.empName));
        System.out.println(empList);

        Collections.sort(empList, (e1, e2) -> e2.empName.compareTo(e1.empName));
        System.out.println(empList);


    }
}
