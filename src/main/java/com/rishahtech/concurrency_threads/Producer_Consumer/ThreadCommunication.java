package com.rishahtech.concurrency_threads.producer_consumer;

class SharedResource {

    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) {

        while (hasData) {
            try {
                System.out.println(Thread.currentThread().getName()
                        + " waiting - buffer is full");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        data = value;
        hasData = true;

        System.out.println(Thread.currentThread().getName()
                + " produced: " + value);

        notifyAll();
    }

    public synchronized int consume() {

        while (!hasData) {
            try {
                System.out.println(Thread.currentThread().getName()
                        + " waiting - buffer is empty");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return -1;
            }
        }

        int value = data;
        hasData = false;

        System.out.println(Thread.currentThread().getName()
                + " consumed: " + value);

        notifyAll();

        return value;
    }
}

class Producer implements Runnable {

    private final SharedResource resource;
    private final int itemCount;

    public Producer(SharedResource resource, int itemCount) {
        this.resource = resource;
        this.itemCount = itemCount;
    }

    @Override
    public void run() {

        for (int i = 1; i <= itemCount; i++) {

            resource.produce(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println(Thread.currentThread().getName()
                + " finished.");
    }
}

class Consumer implements Runnable {

    private final SharedResource resource;
    private final int itemCount;

    public Consumer(SharedResource resource, int itemCount) {
        this.resource = resource;
        this.itemCount = itemCount;
    }

    @Override
    public void run() {

        for (int i = 1; i <= itemCount; i++) {

            resource.consume();

            try {
                Thread.sleep(1000); // slower than producer
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println(Thread.currentThread().getName()
                + " finished.");
    }
}

public class ThreadCommunication {

    private static final int TOTAL_ITEMS = 5;

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread producer = new Thread(
                new Producer(sharedResource, TOTAL_ITEMS),
                "Producer-Thread");

        Thread consumer = new Thread(
                new Consumer(sharedResource, TOTAL_ITEMS),
                "Consumer-Thread");

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Application completed.");
    }
}