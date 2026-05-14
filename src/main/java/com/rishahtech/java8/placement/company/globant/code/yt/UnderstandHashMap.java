package com.rishahtech.java8.placement.company.globant.code.yt;

import java.util.HashMap;
import java.util.Objects;

/*
PROBLEM STATEMENT
-----------------
We want to store user details in a HashMap where:

Key   -> User
Value -> UserDetails

Example:
(User(101, "Rishabh")) -> (Indore, Java Developer)

Later, another part of application creates a NEW User object
with the same business data:

User(101, "Rishabh")

Question:
Will HashMap be able to retrieve the stored UserDetails?

Expected:
Yes, because logically both users represent same person.

Challenge:
HashMap works using hashCode() and equals().
If custom object does not override them correctly,
lookup will fail and return null.
*/

class User {

    /*
    Key fields used to uniquely identify user.

    Marked final to make object immutable.

    Why?
    If key changes after insertion, HashMap lookup breaks.
    */
    private final int userId;
    private final String userName;

    User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    /*
    equals() tells HashMap:
    When should 2 User objects be considered same?
    */
    @Override
    public boolean equals(Object obj) {

        // same memory reference
        if (this == obj) return true;

        // null or different class
        if (obj == null || getClass() != obj.getClass()) return false;

        User user = (User) obj;

        /*
        Business equality:
        same userId + same userName => same logical user
        */
        return userId == user.userId &&
                Objects.equals(userName, user.userName);
    }

    /*
    hashCode() decides bucket placement in HashMap.

    Rule:
    If equals() returns true,
    hashCode() must also be same.
    */
    @Override
    public int hashCode() {
        return Objects.hash(userId, userName);
    }
}

class UserDetails {
    String location;
    String role;

    UserDetails(String location, String role) {
        this.location = location;
        this.role = role;
    }

    @Override
    public String toString() {
        return location + " " + role;
    }
}

public class UnderstandHashMap {
    public static void main(String[] args) {

        /*
        HashMap structure:
        Key   -> User
        Value -> UserDetails
        */
        HashMap<User, UserDetails> map = new HashMap<>();

        /*
        STEP 1:
        Create first user object
        */
        User user1 = new User(101, "Rishabh");

        /*
        Associated details
        */
        UserDetails userDetails1 =
                new UserDetails("Indore", "Java Developer");

        /*
        STEP 2:
        Store in HashMap

        Internally:
        1. HashMap calls user1.hashCode()
        2. Finds bucket
        3. Stores:
           user1 -> userDetails1
        */
        map.put(user1, userDetails1);

        /*
        STEP 3:
        Later application creates NEW object
        with SAME business data
        */
        User user2 = new User(101, "Rishabh");

        /*
        STEP 4:
        Retrieve using new object

        Internally:
        1. HashMap calls user2.hashCode()
        2. Goes to same bucket as user1
        3. Calls user2.equals(user1)
        4. equals returns true
        5. Value returned
        */
        System.out.println("Fetched Value: " + map.get(user2));

        /*
        Proof:
        Both hashcodes same
        */
        System.out.println("user1 hashCode: " + user1.hashCode());
        System.out.println("user2 hashCode: " + user2.hashCode());
    }
}