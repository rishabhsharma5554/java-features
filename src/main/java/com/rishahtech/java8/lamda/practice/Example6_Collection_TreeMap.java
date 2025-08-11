package com.rishahtech.java8.lamda.practice;

import java.util.TreeMap;

public class Example6_Collection_TreeMap {
    public static void main(String[] args) {
        //default - ASC
        //customized - DSC
        TreeMap<Integer, String> tmap = new TreeMap<>((e1, e2) -> e2 - e1);

        tmap.put(100, "Rishabh");
        tmap.put(52, "Mohit");
        tmap.put(25, "Madhu");
        System.out.println(tmap);
    }
}
