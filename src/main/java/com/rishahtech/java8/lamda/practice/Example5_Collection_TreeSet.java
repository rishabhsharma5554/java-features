package com.rishahtech.java8.lamda.practice;

import java.util.TreeSet;

public class Example5_Collection_TreeSet {
    public static void main(String[] args) {
        //default - ASC
        //customized - DSC
        TreeSet<Integer> tset = new TreeSet<>((a, b) -> b - a);
        tset.add(6);
        tset.add(10);
        tset.add(1);
        tset.add(65);
        System.out.println(tset);
    }
}
