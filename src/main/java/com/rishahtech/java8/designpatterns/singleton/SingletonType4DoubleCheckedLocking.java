package com.rishahtech.java8.designpatterns.singleton;
//Synchronized singleton locks every call even after object creation,
//causing performance overhead. Double-checked locking minimizes
//synchronization by locking only during first initialization while remaining thread-safe.
public class SingletonType4DoubleCheckedLocking {
    //Why volatile : The volatile keyword in Java is used to ensure that changes made to a variable are immediately visible to all threads
//    JVM may reorder:
//
//    Actual creation steps:
//
//    1. allocate memory
//    2. assign reference
//    3. run constructor
//
//    Reordering may become:
//
//    1. allocate memory
//    2. assign reference
//    3. constructor not finished yet
//
//    Another thread sees: instance != null and gets partially initialized object. Bad bug. volatile prevents this.

//    Without volatile, double-checked locking can fail because of instruction reordering + memory visibility issues.
    private static volatile SingletonType4DoubleCheckedLocking singletonObj;

    private SingletonType4DoubleCheckedLocking() {}

    //removed synchronized
    public static SingletonType4DoubleCheckedLocking getInstance()
    {
//        if(singletonObj == null)
//            singletonObj = new SingletonType4DoubleCheckedLocking();
        if(singletonObj == null) {
            synchronized (SingletonType4DoubleCheckedLocking.class) {
                if (singletonObj == null)
                    singletonObj = new SingletonType4DoubleCheckedLocking();
            }
        }
        return singletonObj;
    }

    public static void main(String[] args) {
        SingletonType4DoubleCheckedLocking obj = SingletonType4DoubleCheckedLocking.getInstance();

        /*
        Why "double" check?
        Suppose two threads arrive together.

        T1: if(instance == null) -> true
        T2: if(instance == null) -> true

        Both reach synchronized section.

        T1 enters first: creates instance.
        T2 enters later.

        Without second check:
        instance = new Singleton();
        T2 creates another object. Broken singleton.

        So second check prevents that:

        if(instance == null)
        inside lock.
        */
    }
}

