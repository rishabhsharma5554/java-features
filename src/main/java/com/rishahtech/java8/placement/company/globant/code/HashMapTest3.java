package com.rishahtech.java8.placement.company.globant.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Objects;

@AllArgsConstructor
@ToString
@Getter
class Department {
    String deptName;
    String building;
}

@AllArgsConstructor
@ToString
@Getter
class Student {
    int rollNo;
    Department department; // Class3 reference inside Class1

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return rollNo == student.rollNo
                && Objects.equals(department.getDeptName(), student.department.getDeptName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo, department.getDeptName());
    }
}

@AllArgsConstructor
@ToString
@Getter
class Result {
    String grade;
    double percentage;
}

// Map<Student, Result> — Student (Class1) has Department (Class3) inside it
public class HashMapTest3 {
    public static void main(String[] args) {
        HashMap<Student, Result> map = new HashMap<>();

        Department cse = new Department("CSE", "Block-A");
        Department ece = new Department("ECE", "Block-B");

        Student s1 = new Student(1, cse);
        Student s2 = new Student(2, ece);

        map.put(s1, new Result("A", 85.5));
        map.put(s2, new Result("B", 72.0));

        // Lookup using a new object with same rollNo & department
        Student lookup = new Student(1, cse);
        System.out.println("Lookup s1: " + map.get(lookup));

        // Print all entries
        map.forEach((student, result) ->
                System.out.println(student + " -> " + result));
    }
}
