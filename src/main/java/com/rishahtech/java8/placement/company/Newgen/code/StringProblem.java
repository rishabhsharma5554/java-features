package com.rishahtech.java8.placement.company.Newgen.code;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class StringProblem {
    //	aabccdaccasbhhhdk
//	aabccdacsbhhhdk
    public static void main(String[] args) {
        String input = "aabccdaccasbhhhdk";
        HashMap<Character, Integer> hMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            if (hMap.containsKey(ch) && hMap.get(ch) < 4) {
                sb.append(ch);
                hMap.put(ch, hMap.get(ch) + 1);
            } else
                hMap.put(ch, 1);
        }
        System.out.println(sb.toString());


        Set<Character> keySet = hMap.keySet();
        Set<Entry<Character, Integer>> entrySet = hMap.entrySet();
        for (Entry<Character, Integer> entry : hMap.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            System.out.println(key + "  " + val);
        }
        System.out.println(hMap);
        System.out.println(keySet);
        System.out.println(entrySet);

    }
}
