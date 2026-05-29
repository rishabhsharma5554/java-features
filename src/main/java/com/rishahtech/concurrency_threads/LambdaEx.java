package com.rishahtech.concurrency_threads;

public class LambdaEx {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running"));
        t1.start();

    }
}
