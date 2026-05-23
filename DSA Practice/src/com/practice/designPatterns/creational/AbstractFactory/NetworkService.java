package com.practice.designPatterns.creational.AbstractFactory;

public class NetworkService implements Service{
    @Override
    public String runService() {
        return "Network service running...";
    }
}
