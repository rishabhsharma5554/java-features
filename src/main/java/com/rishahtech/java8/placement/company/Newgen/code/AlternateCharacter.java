package com.rishahtech.java8.placement.company.Newgen.code;

public class AlternateCharacter {
    public static void main(String[] args) {
        String output = "CoNjEcTuRe PrE5EnTeD to mE";
        String input = "conjecture presented to me";
        System.out.println(problem(input));

    }

    public static String problem(String input) {
        boolean flag = false;
        StringBuilder out = new StringBuilder();
        for (char s : input.toCharArray()) {
            if (Character.isWhitespace(s))
                out.append(s);
            else {
                if (flag) {
                    out.append(Character.toLowerCase(s));
                    flag = !flag;
                } else {
                    out.append(Character.toUpperCase(s));
                    flag = !flag;
                }
            }
        }
        return out.toString();
    }
}
