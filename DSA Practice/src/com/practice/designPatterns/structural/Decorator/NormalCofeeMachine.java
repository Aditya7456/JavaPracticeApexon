package com.practice.designPatterns.structural.Decorator;

public class NormalCofeeMachine implements CoffeeMachine{
    @Override
    public void makeSmallCoffee() {
        System.out.println("Normal coffee machine : Making small coffee");
    }

    @Override
    public void makeLargeCoffee() {
        System.out.println("Normal coffee machine : Making large coffee");
    }
}
