package com.practice.designPatterns.structural.Bridge;

public class Instagram implements App{

    PhoneOS os;

    public Instagram(PhoneOS os){
        this.os = os;
    }

    @Override
    public void runApp() {
        System.out.println();
        os.upload("Instagram uploading data");
        os.download("www.instagram.com");
        os.display("Instagram Data");
        os.display("Fresh Data");
        System.out.println();
    }
}
