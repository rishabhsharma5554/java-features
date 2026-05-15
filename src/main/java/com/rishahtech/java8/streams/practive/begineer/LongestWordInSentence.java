package com.rishahtech.java8.streams.practive.begineer;

import java.util.Comparator;
import java.util.List;

public class LongestWordInSentence {
    public static void main(String[] args) {

        //find the longest word in a sentence using stream
        String sentence  = "This is my world, and I am the hero of my own story, ILoveMyIndia";
        List<String> sentenceList = List.of(sentence.split(" "));
        sentenceList.stream()
                .max(Comparator.comparingInt(String::length))
                .ifPresent(System.out::println);
    }
}
