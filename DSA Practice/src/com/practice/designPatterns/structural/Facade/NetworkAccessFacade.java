package com.practice.designPatterns.structural.Facade;

public class NetworkAccessFacade {
    private Comm comm = new Comm();
    private Cache cache = new Cache();
    private Convertor convertor = new Convertor();
    private Interceptor interceptor = new Interceptor();

    public void communicate(){
        cache.cache();
        comm.send("Some data");
        comm.receive();
        interceptor.intercept();
        convertor.convert();

    }
}
