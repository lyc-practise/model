package com.pattern.command;

/**
 * recepter
 * 命令接收器
 */
public class Data {

    private int data = 0;
    public void add(int plus){
        data += plus;
//        this.data = this.data + plus;
        printData();
    }
    public void minus(int minus){
        this.data = this.data - minus;
        printData();
    }
    public int getData(){
        return this.data;
    }

    public void printData(){
        System.out.println("data:" + this.data);
    }


    public static void main(String[] args) {

        int a = 0 ;
        a += 1;
        System.out.println("a += 1 : " + a);
        a += 2;
        System.out.println("a += 2 : " + a);
        a =+ 4;
        System.out.println("a =+ 3 : " + a);

    }
}
