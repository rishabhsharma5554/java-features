package com.rishahtech.java8.stringss;

//Step 1 : Make class final
public final class Employee {

    // Step 2 : Make fields private final
    private final int id;
    private final String name;

    // Step 3 : Initialize fields via constructor
    Employee(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    //Step 4 : no setters
    //Step 5 : Only getters
    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }
}
