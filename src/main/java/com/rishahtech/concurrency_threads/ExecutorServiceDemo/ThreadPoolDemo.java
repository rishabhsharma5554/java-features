package com.rishahtech.concurrency_threads.ExecutorServiceDemo;

/*
Thread Group

Based on functinality, we can group threads into a single unit which is nothing but, Thread Group.  i.e ThreadGroup contains a group of threads.  In addition to threads, Thread group can also contain sub-thread groups.

The main advantage of maintaining threads in the form of Thead Group is we can perform common operations very easily

-----------

Every Thread in java belongs to some thread group.
class Test
{
    psvm(String []args)  //main thread belongs to which group?
    {
        Sop(Thread.currentThread().getThreadGroup().getName()); //main Group
    }
}

Every thread in java belongs to some group, Main thread belongs to main group.
Every Thread  group in java, is child group of System Group either (directly/Indirectly)
Hence System Group is parent/Root of all threads Groups in Java.

System Group contains System level threads.
1. Finalizer (GC)
2. Reference Handler
3. Signal Dispatcher
4. Attached Listener .....




Object <------- ThreadGroup (Class) java.lang

Constructors
ThreadGroup()
ThreadGroup(String name)
ThreadGroup(ThreadGroup parent, String name)
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
        System.out.println(Thread.currentThread().getThreadGroup());


        ThreadGroup group = new ThreadGroup("FirstGroup");
        ThreadGroup subGroup = new ThreadGroup(group, "SubGroup");
        Thread t1 = new Thread(subGroup, () -> System.out.println("Thread is running"));
        t1.start();
        System.out.println(t1.getThreadGroup().getName());
        System.out.println(t1.getThreadGroup().getParent().getName());
    }
}
