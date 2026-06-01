package com.practice.designPatterns.structural.Flyweight;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Fighter> army = new ArrayList<>();
    public void spawnFighter(FighterRank rank){
        Fighter f = FighterFactory.getFighter(rank);
        army.add(f);
    }
    public void drawArmy(){
        for(Fighter f: army){
            switch (f.getRank()){
                case PRIVATE: System.out.print("P ");
                break;
                case SERGEANT: System.out.print("S ");
                break;
                default:System.out.print("M ");
                break;
            }
        }
    }

}
