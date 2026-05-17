package com.rishahtech.java8.placement.company.globant.code.code;

public class PalindromeString {
    public static void main(String[] args) {
        String s = "Rar".toLowerCase();
        String s1 = s.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(s1);

        int left = 0 ,right = s1.length()-1;
        while(left < right)
        {
            if(s1.charAt(left)!=s1.charAt(right))
            {
                System.out.println("Not Palindrome");
                return;
            }
            left++;
            right--;
        }
        System.out.println("Palindrome");
    }
}
