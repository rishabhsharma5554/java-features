package com.rishahtech.java8.lamda.practice;

import java.util.ArrayList;
import java.util.Collections;

public class Example4_Collection_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(65);
        al.add(23);
        al.add(1);
        al.add(3);
        al.add(90);
        System.out.println(al);
//		Collections.sort(al);
//		System.out.println(al);

        //Descending order
        Collections.sort(al, (e1, e2) -> e2 - e1);
        System.out.println(al);

        //Ascending
        Collections.sort(al, (e1, e2) -> e1 - e2);
        System.out.println(al);
    }
}
