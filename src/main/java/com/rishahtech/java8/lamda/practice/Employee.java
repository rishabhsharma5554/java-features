package com.rishahtech.java8.lamda.practice;

public class Employee {
    int empNo;
    String empName;

    Employee(int empNo, String empName) {
        this.empName = empName;
        this.empNo = empNo;
    }

    @Override
    public String toString() {
        return empNo + " " + empName;
    }
}