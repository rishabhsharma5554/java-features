package com.rishahtech.java8.placement.company.globant.code;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupLength {
    public static void main(String[] args) {
        List<String> name = Arrays.asList("Rishabh","Sharma","Mohit","Rishabh");
        System.out.println(name.stream()
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting())));
    }
}
