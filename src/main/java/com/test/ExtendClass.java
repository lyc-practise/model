package com.test;

public class ExtendClass {

    static class Father{

        public void run(){

            System.out.println("father run");
            call();
        }

        public void call(){
            System.out.println("father call");
        }
    }

    static class Son extends Father{
        @Override
        public void call(){
            System.out.println("son call");
        }
    }

    public static void main(String[] args) {
        Father son = new Son();
        son.run();
    }
}
