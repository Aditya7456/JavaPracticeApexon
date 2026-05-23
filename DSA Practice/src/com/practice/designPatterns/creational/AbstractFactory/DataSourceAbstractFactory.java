package com.practice.designPatterns.creational.AbstractFactory;

public interface DataSourceAbstractFactory {
    Service createService();
    Response createResponse();
}
