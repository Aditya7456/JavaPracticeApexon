package com.practice.designPatterns.creational.AbstractFactory;

public class DatabaseService implements Service{
    @Override
    public String runService() {
        return "Database Service Running";
    }
}
