package com.rishahtech.worldpay.round1;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Print the non repetable numbers
public class Code1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,3,3,2,8,1);
        System.out.println(numbers);
        System.out.println("Print the non repeatable . ");
        numbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach( (e) -> System.out.print(e+" "));

        System.out.println("\nNow Remove {2,8} which we got, from the remaining numbers and also remove duplicated and print those in same order. ");
        numbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(num -> System.out.print(num+" "));

    }
}
