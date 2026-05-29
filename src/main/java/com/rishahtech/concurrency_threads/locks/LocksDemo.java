package com.rishahtech.concurrency_threads.locks;

/*
Intrinsic Lock - build into every object, synchronized keyword uses this lock
Explicit Lock - java.util.concurrent.locks.Lock
 */
public class LocksDemo {
    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();
        Runnable task = () -> sbi.withdraw(50);

        Thread t1 = new Thread(task, "t1");
        Thread t2 = new Thread(task, "t2");
        t1.start();
        t2.start();
    }
}