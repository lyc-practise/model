package com.test;


public class TestAssert {


    public static void main(String[] args) {


        int a = 1;

//        assert a>1:"错啦!";


        String abc = "呵呵";
        byte[] bytes = abc.getBytes();
        for(byte b : bytes){
            System.out.println(b);
        }


    }


}
