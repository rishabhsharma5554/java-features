package com.rishahtech.java8.stringss;


public class ContractTest {
    public static void main(String[] args) {
        //In String equals and hashcode are overriden for content comparison
        // that why same hashcode
        String s1 = new String("Rishabh");
        String s2 = new String("Rishabh");

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1 == s2);

        System.out.println();
        // In String buffer hashCode and equals methods are not overriden for
        // content comparison that why different hashcode
        StringBuffer s3 = new StringBuffer("Rishabh");
        StringBuffer s4 = new StringBuffer("Rishabh");
        System.out.println(s3.equals(s4));
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
        System.out.println(s3 == s4);
    }
}
