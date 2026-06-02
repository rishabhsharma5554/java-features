package com.rishahtech.concurrency_threads.ExecutorServiceDemo;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception{
        //uses fork join pool executor
//        CompletableFuture<Integer> f1 = CompletableFuture
//                .supplyAsync(() -> 10)
//                .thenApply(num -> num * num)
//                .thenApply(res -> res+1);

        CompletableFuture<Void> f1 = CompletableFuture
                .supplyAsync(() -> 10)
                        .thenAccept( result -> System.out.println(result));

        System.out.println(f1.get());

    }
}
