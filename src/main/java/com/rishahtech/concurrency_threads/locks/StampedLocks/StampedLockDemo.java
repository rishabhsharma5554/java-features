package com.rishahtech.concurrency_threads.locks.StampedLocks;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {

    private int value = 100;
    private final StampedLock lock = new StampedLock();

    // Write
    public void update(int newValue) {
        long stamp = lock.writeLock();
        try {
            value = newValue;
            System.out.println("Updated value = " + value);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    // Optimistic Read
    public int read() {
        long stamp = lock.tryOptimisticRead();
        int currentValue = value;

        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                currentValue = value;
            } finally {
                lock.unlockRead(stamp);
            }
        }

        return currentValue;
    }

    public static void main(String[] args) {

        StampedLockDemo obj = new StampedLockDemo();

        new Thread(() -> {
            System.out.println("Read: " + obj.read());
        }).start();

        new Thread(() -> {
            obj.update(200);
        }).start();
    }
}