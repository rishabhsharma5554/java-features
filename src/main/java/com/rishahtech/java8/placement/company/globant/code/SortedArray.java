package com.rishahtech.java8.placement.company.globant.code;

import java.util.Arrays;
//time complexity
//Since both arrays are already sorted, merging them takes linear time O(n + m) with O(n + m) extra space.
public class SortedArray {

    public static void main(String[] args) {
        int []arr1 = new int[]{1,3,5};
        int []arr2 = new int[]{2,4,6,8};

        // out put 1,2,3,4,5,6,8

        int[] result = SortedArray.sortArray(arr1,arr2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] sortArray(int []arr1, int[]arr2)
    {
        int totalLength = arr1.length + arr2.length;
        int result[] = new int[totalLength];
        int i=0, j=0, k=0;
        while(i<arr1.length && j<arr2.length)
        {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }
}
