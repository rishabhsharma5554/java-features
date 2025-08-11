package com.rishahtech.java8.lamda.practice;

import java.util.function.Predicate;

public class Example9_FI_Predicate {

    public static void main(String[] args) {
        //Check if number>10
        Predicate<Integer> p = num -> num > 10;
        System.out.println(p.test(25));
        System.out.println(p.test(2));

        //check if string length > 3
        Predicate<String> strP = str -> str.length() > 3;
        System.out.println(strP.test("Rishabh"));
        System.out.println(strP.test("Zia"));

    }

}
