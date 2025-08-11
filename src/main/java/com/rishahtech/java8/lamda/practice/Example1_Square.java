package com.rishahtech.java8.lamda.practice;

interface SquareInterface {
    public int square(int num);
}

public class Example1_Square {
    public static void main(String[] args) {
        SquareInterface i1Ref = x -> x * x;
        int square = i1Ref.square(25);
        System.out.println(square);
    }
}
