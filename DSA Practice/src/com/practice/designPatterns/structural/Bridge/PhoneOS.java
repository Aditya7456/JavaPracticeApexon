package com.practice.designPatterns.structural.Bridge;

public interface PhoneOS {
    void upload(String data);
    void download(String url);
    void display(String data);
}
