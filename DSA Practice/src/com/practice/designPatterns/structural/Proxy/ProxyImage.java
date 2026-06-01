package com.practice.designPatterns.structural.Proxy;

public class ProxyImage implements Image{
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName){
        this.fileName=fileName;
    }

    @Override
    public void display() {
        System.out.println("Proxy image: Displaying " + fileName);
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
        System.out.println("Proxy image: logging " + realImage);
    }
}
