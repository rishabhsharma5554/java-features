package com.rishahtech.java8.streams.practive.begineer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringsToCharacter {
    public static void main(String[] args) {
        // input - Strings ("Rishabh", "Sharma")
        // output - Convert to character - [R, i, s, h, a, b, h, S, h, a, r, m, a]
        List<String> str = Arrays.asList("Rishabh", "Sharma");

        List<String> flatMapped = str.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .collect(Collectors.toList());

        List<Character> ff = str.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .toList();

        System.out.println(ff);
        System.out.println(flatMapped);
    }
}
