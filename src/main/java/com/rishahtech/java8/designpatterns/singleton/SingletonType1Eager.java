package com.rishahtech.java8.designpatterns.singleton;

//Purpose: Ensure only one instance of a class exists and provide global access.
//Eager Initialization - Instance created when class loads.
public class SingletonType1Eager {
    private static final SingletonType1Eager singletonObj = new SingletonType1Eager();

    private SingletonType1Eager()
    {

    }

    public static SingletonType1Eager getInstance()
    {
        return singletonObj;
    }

    public static void main(String[] args) {
        SingletonType1Eager obj = SingletonType1Eager.getInstance();

        /*
        Pros:
        Simple
        Thread-safe (class loading is thread-safe)

        Cons:
        Object created even if never used
        */
    }
}

