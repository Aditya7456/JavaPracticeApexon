package com.practice.designPatterns.creational.Prototype;

public class Client {
    public static void main(String[] args) {
        Vehicle c1 = new Car(4,3000,"red");
        Vehicle c2 = c1.clone();

        c2.isClone(c1);
        c1.isClone(c2);

        Vehicle b1 = new BiCycle(2,1000,true);
        Vehicle b2 = b1.clone();

        b2.isClone(b1);
        b1.isClone(b2);

        b1.isClone(c1);
    }
}
