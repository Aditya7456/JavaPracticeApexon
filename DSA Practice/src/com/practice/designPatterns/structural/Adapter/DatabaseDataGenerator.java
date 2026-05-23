package com.practice.designPatterns.structural.Adapter;

import java.util.ArrayList;
import java.util.List;

public class DatabaseDataGenerator {
    public List<DatabaseData> generateData(){
        List<DatabaseData> list = new ArrayList<>();
        list.add(new DatabaseData(2,3));
        list.add(new DatabaseData(3,12));
        list.add(new DatabaseData(4,23));
        return list;
    }
}
