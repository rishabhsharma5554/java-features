package com.rishahtech.java8.placement.company.globant.code.code;

import java.util.*;

public class DuplicateElements {
    public static void main(String[] args) {
        int []arr = {1,1,2,5,6,7,89,4,9,4,8,56,9,788};

        // Approach 1: Using HashSet — O(n) time, O(n) space
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        System.out.println("Duplicates (HashSet): " + duplicates);

        // Approach 2: Brute force — O(n^2) time, O(1) space
        System.out.print("Duplicates (Brute):   ");
        Set<Integer> printed = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && printed.add(arr[i])) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
        System.out.println();

        // Approach 3: Streams — O(n) time
        Set<Integer> seenSet = new HashSet<>();
        List<Integer> streamDuplicates = Arrays.stream(arr)
                .boxed()
                .filter(n -> !seenSet.add(n))
                .distinct()
                .toList();
        System.out.println("Duplicates (Stream):  " + streamDuplicates);
    }
}
