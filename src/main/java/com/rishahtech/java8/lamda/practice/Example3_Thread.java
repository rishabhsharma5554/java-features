package com.rishahtech.java8.lamda.practice;

public class Example3_Thread {
    public static void main(String[] args) {
        Runnable r = () -> {
            for (int i = 0; i < 10; i++)
                System.out.println(i + "Child Thread.");
        };

        Thread t = new Thread(r);
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(i + "Main Thread.");
        }
    }
}
