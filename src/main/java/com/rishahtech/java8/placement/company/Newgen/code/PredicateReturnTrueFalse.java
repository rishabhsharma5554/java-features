package com.rishahtech.java8.placement.company.Newgen.code;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateReturnTrueFalse {
    public static void main(String[] args) {

        Predicate<Integer> pre = (num) -> {
            if (num > 15)
                return true;
            else
                return false;
        };

        BiPredicate<Integer, Integer> bPre = (n1, n2) -> {
            if ((n1 + n2) > 5)
                return true;
            else
                return false;
        };

        System.out.println(pre.test(65));
        System.out.println(bPre.test(25, 65));

    }
}
