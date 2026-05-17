package com.rishahtech.java8.placement.company.globant.code.code;

import java.util.Arrays;
import java.util.Comparator;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,4,5,24241,21,5};
        int[] sortedASCArray = Arrays.stream(arr).sorted().toArray();
        int [] sortedDESCArray = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int[] removedDuplicate = Arrays.stream(arr).distinct().toArray();
        System.out.println("ASC:  " + Arrays.toString(sortedASCArray));
        System.out.println("DESC: " + Arrays.toString(sortedDESCArray));
        System.out.println("Duplicate Removed:  " + Arrays.toString(removedDuplicate));

        //reverse an array by Code
        System.out.println("\nOriginal Array : "+Arrays.toString(arr));
        System.out.println("Reverse Array without sort :  " + Arrays.toString(reverseArray(arr)));

    }

    // O(n)
    public static int[] reverseArray(int[] arr) {
        int []result = new int[arr.length];
        int l = 0;
        int r = arr.length - 1;

        while(r >=0 )
            result[l++] = arr[r--];
        return result;
    }

    // O(n) time, O(n) space — same as reverseArray, just uses l<=r instead of r>=0
    public static int[] reverseArrayWithCopy(int[] arr) {
        int []result = new int[arr.length];
        int l = 0;
        int r = arr.length - 1;
        while(l <= r)
            result[l++] = arr[r--];
        return result;
    }

    // O(n) time, O(1) space — in-place swap (truly optimized)
    public static void reverseArrayInPlace(int[] arr) {
        int l = 0, r = arr.length - 1;
        while(l < r) {
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

}
