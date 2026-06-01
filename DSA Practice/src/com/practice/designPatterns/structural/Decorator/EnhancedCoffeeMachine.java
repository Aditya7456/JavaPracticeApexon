package com.practice.designPatterns.structural.Decorator;

public class EnhancedCoffeeMachine implements CoffeeMachine{

    private NormalCofeeMachine machine;

    // override behaviour

    @Override
    public void makeSmallCoffee() {
        System.out.println("Enhanced coffee machine: Making small coffee");
    }

    // unaltered behaviour
    @Override
    public void makeLargeCoffee() {
//        System.out.println("Enhanced coffee machine: Making large coffee");
        machine.makeLargeCoffee();
    }

    public void makeMilkCoffee(){
        System.out.println("Enhanced coffee machine: Making milk coffee");
        machine.makeLargeCoffee();
        System.out.println("Enhanced coffee machine: Adding milk");
    }

    public EnhancedCoffeeMachine(NormalCofeeMachine machine){
        this.machine = machine;
    }
}
