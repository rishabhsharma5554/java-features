package com.rishahtech.java8.placement.company.Newgen.code;

public class ReverseStringInSentence {
    public static void main(String[] args) {

        String output = "sihT si a gnirtS";
        String input = "This is a String";
        System.out.println(reverseString(input));
    }

    static String reverseString(String input) {
        String output = "";
        String[] inputs = input.split(" ");
        for (String s : inputs) {
            StringBuilder sb = new StringBuilder(s).reverse().append(" ");
            output += sb.toString();
        }

        return output;
    }
}
