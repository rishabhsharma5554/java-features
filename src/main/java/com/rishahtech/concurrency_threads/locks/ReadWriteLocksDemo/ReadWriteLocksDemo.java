package com.rishahtech.concurrency_threads.locks.ReadWriteLocksDemo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedData
{
    private String data = "Initial";

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read()
    {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()
                    + " reading: " + data);

            Thread.sleep(3000);

            System.out.println(Thread.currentThread().getName()
                    + " finished reading");
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }finally {
            lock.readLock().unlock();
        }
    }


    public void  write(String value)
    {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()
                    + " writing: " + value);

            Thread.sleep(3000);

            data = value;

            System.out.println(Thread.currentThread().getName()
                    + " finished writing");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.writeLock().unlock();
        }
    }


}

public class ReadWriteLocksDemo {
    public static void main(String[] args) throws Exception {
        SharedData sharedData = new SharedData();

        Thread t1 = new Thread(sharedData::read, "Reader-1");
        Thread t2 = new Thread(sharedData::read, "Reader-2");
        Thread t3 = new Thread(sharedData::read, "Reader-3");
        Thread t4 = new Thread(() -> sharedData.write("Updated-Data"), "Writer-1");
        t4.start();

        t1.start();
        t2.start();
        t3.start();
//        Thread.sleep(500);
    }
}