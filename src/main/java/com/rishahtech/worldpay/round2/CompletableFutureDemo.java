package com.rishahtech.worldpay.round2;

import java.util.concurrent.*;

class Add implements Callable
{
    Integer a,b;
    public Add(Integer a, Integer b)
    {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception{
        return a+b;
    }
}

class Multiply implements Callable
{
    Integer result;
    public Multiply(Integer result)
    {
        this.result = result;
    }

    @Override
    public Integer call() throws Exception {
        return result * 10;
    }
}

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Future blocking example
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
        Future submit = service.submit(new Add(1, 2));
        Future result = service.submit(new Multiply((Integer) submit.get()));
        System.out.println(result.get());
        service.shutdown();

        //CompletableFuture example
        ExecutorService newService = Executors.newVirtualThreadPerTaskExecutor();
        CompletableFuture.supplyAsync( () -> new Add(1,2))
                .thenAcceptAsync(res -> {
                    try {
                        new Multiply(res.call());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },newService);

    }
}
