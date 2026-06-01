package com.practice.designPatterns.structural.Decorator;

public class Client {
    public static void main(String[] args) {
        NormalCofeeMachine normal = new NormalCofeeMachine();
        EnhancedCoffeeMachine enhanced = new EnhancedCoffeeMachine(normal);

        normal.makeSmallCoffee();
        normal.makeLargeCoffee();
        enhanced.makeSmallCoffee();
        enhanced.makeLargeCoffee();
        enhanced.makeMilkCoffee();

    }
}
