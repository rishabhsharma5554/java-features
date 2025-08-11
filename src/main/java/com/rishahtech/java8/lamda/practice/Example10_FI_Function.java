package com.rishahtech.java8.lamda.practice;

import java.util.function.Function;

public class Example10_FI_Function {

    public static void main(String[] args) {

        //find the length of array
        Function<Integer[], Integer> funT = num -> num.length;
        Integer[] arr = new Integer[]{1, 2, 54, 6, 5};
        System.out.println(funT.apply(arr));


        //delete the duplicates
        Function<Integer[], Integer> p = x -> {
            return x[0];
        };


    }

}
