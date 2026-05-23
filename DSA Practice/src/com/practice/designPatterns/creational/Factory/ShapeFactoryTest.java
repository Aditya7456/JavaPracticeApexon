package com.practice.designPatterns.creational.Factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeFactoryTest {
    ShapeFactory factory = new ShapeFactory();
    Shape roundFood = factory.getFood("Round");
    Shape cylinderFood = factory.getFood("Cylinder");

    @Test
    void factoryMethodTest(){
        assertEquals("Round",roundFood.getShape());
        assertEquals("Cylinder",cylinderFood.getShape());
    }
}