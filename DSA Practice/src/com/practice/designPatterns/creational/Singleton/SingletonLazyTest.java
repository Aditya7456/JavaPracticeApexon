package com.practice.designPatterns.creational.Singleton;

public class SingletonLazyTest {
    public static void main(String[] args){
//        SingletonLazy instance1 = SingletonLazy.getLazyInstance();
//        SingletonLazy instance2 = SingletonLazy.getLazyInstance();
//        System.out.println(instance1);
//        System.out.println(instance2);

        // proof that this is not thread safe
        Runnable task = () ->{
            SingletonLazy obj = SingletonLazy.getLazyInstance();
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
