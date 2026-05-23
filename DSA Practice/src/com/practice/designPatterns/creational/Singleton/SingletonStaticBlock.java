package com.practice.designPatterns.creational.Singleton;

public class SingletonStaticBlock {
    private static SingletonStaticBlock instance;

    static {
        instance = new SingletonStaticBlock();
    }
    private SingletonStaticBlock(){}

    public static SingletonStaticBlock getInstance(){
        return instance;
    }
}
