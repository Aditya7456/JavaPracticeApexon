package com.practice.designPatterns.creational.Prototype;

import java.util.Objects;

public class Car extends Vehicle{
    private String color;

    public Car(int wheels, long price, String color){
        this.wheels = wheels;
        this.price = price;
        this.color = color;
    }

    public Car(Car target){
        super(target);
        if(target!=null){
            this.color = target.color;
        }

    }

    @Override
    public Vehicle clone() {
        return new Car(this);
    }

    @Override
    public boolean isClone(Vehicle target) {
        if(target instanceof Car){
            Car t = (Car) target;
            if(Objects.equals(this.color, t.color) && wheels==t.wheels && price==t.price) {
                System.out.println(this + " and " + t + " are clones.");
                return true;
            }
        }
        System.out.println(this + " and " + target + " are not clones.");
        return false;
    }
}
