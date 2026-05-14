package com.rishahtech.java8.stringss;

public final class User {

    private final String name;
    private final Address address;

    public User(String name, Address address)
    {
        this.name = name;
        this.address = address;
    }

    // no setters
    // only getters
    public String getName()
    {
        return name;
    }

    public Address getAddress()
    {
        return address;
    }
}
