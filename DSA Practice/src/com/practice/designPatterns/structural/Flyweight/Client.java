package com.practice.designPatterns.structural.Flyweight;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        int toDraw = 1000;
        Army army = new Army();
        FighterRank currRank;
        Random random = new Random();

        for(int i = 0; i<toDraw; i++){
            switch(random.nextInt(3)){
                case 0: currRank = FighterRank.PRIVATE;
                break;
                case 1: currRank = FighterRank.MAJOR;
                break;
                default: currRank = FighterRank.SERGEANT;
                break;
            }
            army.spawnFighter(currRank);
        }
        army.drawArmy();;
    }
}
