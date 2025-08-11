package com.rishahtech.java8.placement.company.Deloitte.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareOfNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        // Integer Array to List
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());


        List<Integer> squaredNum = numsList.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("Input + " + numsList + "- Output" + squaredNum);

        // List to Array
        int[] ans = squaredNum.stream().mapToInt(Integer::intValue).toArray();

    }

}
