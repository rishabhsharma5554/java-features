package com.rishahtech.java8.lamda.practice;

@FunctionalInterface
interface LengthInterface {
    public int findLength(int arr[]);
}

public class Example2_Length {
    public static void main(String[] args) {
        LengthInterface lenRef = x -> x.length;

        int nums[] = new int[]{2, 5, 6, 7, 9};
        int len = lenRef.findLength(nums);
        System.out.println(len);
    }
}
