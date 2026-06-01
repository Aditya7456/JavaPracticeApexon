package com.practice.designPatterns.structural.Composite;

import java.util.ArrayList;

public class Composite extends Equipment{
    private ArrayList<Equipment> equipments = new ArrayList<>();

    public Composite(String name){
        super(name,0);
    }
    public Composite add(Equipment eq){
        equipments.add(eq);
        return this;
    }
    @Override
    public int getPrice(){
        int sum = 0;
        for(Equipment eq : equipments){
            sum+=eq.getPrice();
        }
        return sum;
    }
}
