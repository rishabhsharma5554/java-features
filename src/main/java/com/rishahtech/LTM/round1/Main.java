package com.rishahtech.LTM.round1;/*
int[] array = {4, 2, 7, 1, 9, 5, 3, 6, 9};

Find third largest element in an array using Java streams
 
*/

import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        int[] array = {4, 2, 7, 1, 9, 5, 3, 6, 9};
        int result = Arrays.stream(array)
            .distinct()
            .boxed()
            .sorted((a,b) -> b-a)
            .skip(2)
            .findFirst()
            .orElseThrow();
        System.out.println(result);
    }
}