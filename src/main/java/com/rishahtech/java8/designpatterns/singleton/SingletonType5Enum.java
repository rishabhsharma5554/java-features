package com.rishahtech.java8.designpatterns.singleton;
//Why best?
//Protects against:
//
//reflection attacks
//serialization issues
//multiple instance creation
public enum SingletonType5Enum {
    SINGLETON_OBJECT;

    public void doWork() {
        System.out.println("working");
    }

    public static void main(String[] args) {
        SingletonType5Enum.SINGLETON_OBJECT.doWork();
    }
}

