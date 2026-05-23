package com.practice.designPatterns.creational.Singleton;

public class SingletonLazy {
    private static SingletonLazy lazyInstance;

    private SingletonLazy(){
        System.out.println("Singleton Object Created : " + this.hashCode());
    }

    public static SingletonLazy getLazyInstance(){
        if(lazyInstance==null){
            // Simulating delay
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lazyInstance = new SingletonLazy();
        }
        return lazyInstance;
    }
}
