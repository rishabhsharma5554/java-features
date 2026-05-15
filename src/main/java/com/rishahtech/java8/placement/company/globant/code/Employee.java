package com.rishahtech.java8.placement.company.globant.code;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

// equals() and hashCode() contract:
// If two objects are equal by .equals(), they MUST have the same hashCode().
// Both methods must use the SAME fields (here: id, name).
@Setter
@Getter
public class Employee {

    private int id;
    private String name;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;                                    // same reference — always equal
        if (obj == null || getClass() != obj.getClass()) return false;   // null or different type
        Employee other = (Employee) obj;                                 // safe downcast
        return id == other.id && Objects.equals(name, other.name);       // compare fields
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name); // same fields as equals()
    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Rishabh");

        Employee e2 = new Employee();
        e2.setId(1);
        e2.setName("Rishabh");

        System.out.println("Shallow Comparison: " + (e1 == e2));    // false — different objects in memory
        System.out.println("Deep Comparison:    " + e1.equals(e2)); // true  — same id and name
        System.out.println("e1 hashCode: " + e1.hashCode());        // same as e2 — contract satisfied
        System.out.println("e2 hashCode: " + e2.hashCode());
    }
}


