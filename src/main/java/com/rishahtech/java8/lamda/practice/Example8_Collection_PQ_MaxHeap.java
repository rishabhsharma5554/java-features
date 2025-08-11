package com.rishahtech.java8.lamda.practice;

import java.util.PriorityQueue;

public class Example8_Collection_PQ_MaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Employee> maxHeap = new PriorityQueue<>((e1, e2) -> e2.empName.compareTo(e1.empName));

        maxHeap.add(new Employee(100, "Rishabh"));
        maxHeap.add(new Employee(54, "Madhu"));
        maxHeap.add(new Employee(5, "Mohit"));
        maxHeap.add(new Employee(64, "Satya"));
        maxHeap.add(new Employee(23, "Prachi"));
        maxHeap.add(new Employee(876, "Lucky"));

        System.out.println(maxHeap);

    }
}
