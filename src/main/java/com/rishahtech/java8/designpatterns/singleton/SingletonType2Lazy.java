package com.rishahtech.java8.designpatterns.singleton;

//Lazy Initialization (NOT thread-safe)
//Create only when needed.
public class SingletonType2Lazy {
    private static SingletonType2Lazy singletonObj;

    private SingletonType2Lazy()
    {

    }

    public static SingletonType2Lazy getInstance()
    {
        if(singletonObj == null)
            singletonObj = new SingletonType2Lazy();
        return singletonObj;
    }

    public static void main(String[] args) {
        SingletonType2Lazy obj = SingletonType2Lazy.getInstance();

        /*
        Pros.........
        Thread 1:
        instance == null

        Thread 2:
        instance == null

        Both create objects.

        Cons.........
        Object created when 2 threads executes
        */
    }
}

