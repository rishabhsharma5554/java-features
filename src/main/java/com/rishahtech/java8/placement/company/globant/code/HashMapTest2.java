package com.rishahtech.java8.placement.company.globant.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Setter
@Getter
class Employee{
    int id;
    String name;
    Address address;

    public Employee clone() {
        return new Employee(id, name, address.clone());
    }
}
@Setter
@Getter
@AllArgsConstructor
@ToString
class Address{
    String city;
    String state;

    @Override
    public Address clone() {
        return new Address(city,state);
    }
}

public class HashMapTest2 {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1,"Rishabh",new Address("Dewas","MP"));
        System.out.println(emp1);

        // Prototype Pattern: deep clone
        Employee emp2 = emp1.clone();
        emp2.setId(2);

        System.out.println(emp1);
        System.out.println(emp2);
    }
}
