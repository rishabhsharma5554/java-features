package com.rishahtech.java8.parallelStreams.practice;

import java.util.Arrays;
import java.util.List;

public class InterviewQuestionBasic {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("	Sequential Streams Example on Single Core with Single Thread.");
        nums.stream().forEach(num -> {
            System.out.println(num + " " + Thread.currentThread().getName());
        });

        System.out.println("	Parallel Streams Example on Multiple Core with multiple Thread.");
        nums.parallelStream().forEach(num -> {
            System.out.println(num + " " + Thread.currentThread().getName());
        });
    }
}
