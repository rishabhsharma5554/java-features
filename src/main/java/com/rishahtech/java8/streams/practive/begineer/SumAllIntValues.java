package com.rishahtech.java8.streams.practive.begineer;

import java.util.Arrays;
import java.util.List;

public class SumAllIntValues {
    public static void main(String[] args) {

        //sum all the values using streams
        List<Integer> al = Arrays.asList(98, 56, 12, 98, 102, 23, 98, 321, 987, 1223, 95684, 864, 1, 12);
        int sum = al.stream().mapToInt(value -> value).sum();
        System.out.println(sum);

    }
}
