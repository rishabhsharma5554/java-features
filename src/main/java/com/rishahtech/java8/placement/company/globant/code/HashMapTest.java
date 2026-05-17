package com.rishahtech.java8.placement.company.globant.code;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Objects;

/*
I want to store Map<Employee, Address> emp = new HashMap();
 */

@AllArgsConstructor
@ToString
class User{
    Integer id;
    String name;

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        if(Objects.equals(user.id, this.id) && Objects.equals(user.name, this.name)) return true;
        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.id,this.name);
    }
}

@AllArgsConstructor
@ToString
class UserDetails {
    String city;
    String role;
}

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<User,UserDetails> map = new HashMap<>();
        User u1 = new User(1,"Rishabh");
        UserDetails ud1 = new UserDetails("dewas","dev");

        map.put(u1,ud1);
        System.out.println(map.get(u1));

        User u2 = new User(1,"Rishabh");
        UserDetails ud2 = new UserDetails("dewas","dev");
        System.out.println(map.get(u2));
        System.out.println("Map size : "+map.size());
    }
}