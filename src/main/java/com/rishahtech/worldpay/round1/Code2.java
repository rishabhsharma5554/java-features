package com.rishahtech.worldpay.round1;

class A {
    static int x = B.y + 1;
}

class B {
    static int y = A.x + 1;
}

public class Code2 {
    public static void main(String[] args) {
        System.out.println(A.x);
        System.out.println(B.y);
    }
}