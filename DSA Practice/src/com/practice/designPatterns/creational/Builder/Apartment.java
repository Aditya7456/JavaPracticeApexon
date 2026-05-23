package com.practice.designPatterns.creational.Builder;

import java.util.Objects;

public class Apartment {
    private int sqm;
    private int rooms;
    private String city;
    private String area;
    private boolean kitchen;

    public Apartment(int sqm, int rooms, String city, String area, boolean kitchen) {
        this.sqm = sqm;
        this.rooms = rooms;
        this.city = city;
        this.area = area;
        this.kitchen = kitchen;
    }

    public int getSqm(){
        return sqm;
    }
    // all other getters

    public void display(){
        System.out.println();
        System.out.println("Apartment has: ");
        if(sqm!=-1){
            System.out.println(sqm + " sqm");
        }
        if(rooms!=-1){
            System.out.println(rooms + " rooms");
        }
        if(!Objects.equals(city, "")){
            System.out.println("Apartment is in " +  city + " city");
        }
        if(!Objects.equals(area, "")){
            System.out.println("Apartment is in " + area + " area");
        }
        if(kitchen){
            System.out.println("Apartment has a kitchen!");
        }
        System.out.println();
    }
}
