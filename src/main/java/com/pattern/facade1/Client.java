package com.pattern.facade1;

public class Client {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.request();
    }
}
