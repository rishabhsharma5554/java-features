package com.rishahtech.java8.placement.company.globant.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopThreeElements {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(654, 6541, 4516, 456, 321, 521, 89465, 1, 12, 12, 2, 32, 32, 4);
        List<Integer> topThreeNumbers = numbers.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).limit(3).toList();
        System.out.println(topThreeNumbers);


        List<String> names = Arrays.asList("Rishabh","Sharma","Mohit","Rishabh");
        Map<String, Long> collect = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for(Map.Entry<String,Long> name : collect.entrySet())
        {
            System.out.println(name.getKey()+" :  "+name.getValue());
        }
    }
}
