package com.rishahtech.java8.placement.company.globant.code;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;

//Write a Java program to print all characters from a string that occur an even number of times along with their frequency, using Java Streams.

public class MyCode {
  public static void main(String args[]) {
    String str = "Prathammmm";
    str.chars()
    .mapToObj(c-> (char) c)
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    .entrySet()
    .stream()
    .filter(e -> e.getValue() % 2 == 0)
    .forEach(e -> System.out.println(e.getKey() +" -> " +e.getValue()));
  }
}
