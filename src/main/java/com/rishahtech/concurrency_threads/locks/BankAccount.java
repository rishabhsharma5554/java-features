package com.rishahtech.concurrency_threads.locks;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw "+amount);
//        if (balance >= amount) {
//            System.out.println(Thread.currentThread().getName() + " proceeding with withdraw "+amount);
//            try
//            {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            balance -= amount;
//            System.out.println(Thread.currentThread().getName() + " completed withdraw. Remaining balance "+balance);
//        }else {
//            System.out.println("Insufficient balance");
//        }

        lock.lock();
        if(lock.tryLock())
        {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " proceeding with withdraw "+amount);
                try
                {
                    Thread.sleep(3000);
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " completed withdraw. Remaining balance "+balance);
                }
                catch (InterruptedException e) {
                    lock.unlock();
                }
            }else {
                System.out.println("Insufficient balance");
            }
        }
    }
}