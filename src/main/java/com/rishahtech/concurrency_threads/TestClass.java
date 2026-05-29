package com.rishahtech.concurrency_threads;

class MyClass extends  Thread
{

    public MyClass(String threadName) {
        super(threadName);
    }
    public void run() {
       while(true)
       {
           System.out.println("Thread name : " + Thread.currentThread().getName());
       }
    }
}

public class TestClass {
    public static void main(String[] args) throws InterruptedException {
        MyClass t1 = new MyClass("Rishabh");
        t1.setDaemon(true);
        t1.start();

        System.out.println("Main thread name : " + Thread.currentThread().getName());
        System.out.println("Main done");
    }
}
