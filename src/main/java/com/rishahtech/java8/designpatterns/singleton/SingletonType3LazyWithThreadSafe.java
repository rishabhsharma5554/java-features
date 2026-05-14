package com.rishahtech.java8.designpatterns.singleton;

//Lazy Initialization (NOT thread-safe)
//Create only when needed.
public class SingletonType3LazyWithThreadSafe {
    private static SingletonType3LazyWithThreadSafe singletonObj;

    private SingletonType3LazyWithThreadSafe()
    {

    }

    public static synchronized SingletonType3LazyWithThreadSafe getInstance()
    {
        if(singletonObj == null)
            singletonObj = new SingletonType3LazyWithThreadSafe();
        return singletonObj;

//        What happens here?
//            Because method is synchronized, only one thread can enter at a time.
//        Suppose singleton already created.
//
//        Thread1 getInstance();
//        Thread2 getInstance();
//        Thread3 getInstance();
//
//        Even though object already exists: singletonObj != null
//        still:
//        T1 enters
//        T2 waits
//        T3 waits
//        Because lock is acquired for the entire method.

    }

    public static void main(String[] args) {
        SingletonType3LazyWithThreadSafe obj = SingletonType3LazyWithThreadSafe.getInstance();

        /*
        Pros:
        Safe

        Cons:
        Slow (synchronized on every call)
        */
    }
}

