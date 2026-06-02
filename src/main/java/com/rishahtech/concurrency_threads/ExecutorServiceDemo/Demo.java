package com.rishahtech.concurrency_threads.ExecutorServiceDemo;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws Exception{

        ExecutorService executor  = Executors.newFixedThreadPool(4);
        Future<Integer> res = executor.submit(() -> {
            int sum = 0;
            for(int i=0; i<10;i++)
                sum+=i;
            return sum;
        });

        System.out.println(res.get());
        executor.shutdown();
    }
}
