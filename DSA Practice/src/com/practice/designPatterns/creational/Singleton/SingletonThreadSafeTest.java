package com.practice.designPatterns.creational.Singleton;

public class SingletonThreadSafeTest {
    public static void main(String[] args){
        // proof that this is not thread safe
        Runnable task = () ->{
            SingletonThreadSafe obj = SingletonThreadSafe.getInstance();
            System.out.println(
                    Thread.currentThread().getName()
                            + " -> "
                            + obj.hashCode()
            );
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}
