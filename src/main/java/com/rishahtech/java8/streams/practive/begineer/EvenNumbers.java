package com.rishahtech.java8.streams.practive.begineer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {
    public static void main(String[] args) {

        // input -> int numbers
        // output -> all even numbers [6, 8]
        int[] a = {1, 5, 6, 8, 9};
        List<Integer> result = Arrays.stream(a)
                .filter(num -> num % 2 == 0)
                .boxed()
                .toList();
        System.out.println(result);
    }
}