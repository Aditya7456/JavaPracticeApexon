package com.practice.designPatterns.structural.Bridge;

public class Facebook implements App{

    private PhoneOS os;
    public Facebook(PhoneOS os){
        this.os = os;
    }

    @Override
    public void runApp() {
        System.out.println();
        os.upload("Facbook data upload");
        os.download("www.facebook.com");
        os.display("Facebook Data");
        System.out.println();
    }
}
