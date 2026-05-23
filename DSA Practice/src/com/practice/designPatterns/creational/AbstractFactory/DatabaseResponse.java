package com.practice.designPatterns.creational.AbstractFactory;

public class DatabaseResponse implements Response{
    @Override
    public String getResponse() {
        return "Database response";
    }
}
