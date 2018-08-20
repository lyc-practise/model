package com.sort;

import java.util.Random;

public class Client {

    public static int[] copyArray(int[] source){
        int[] dir = new int[source.length];
        System.arraycopy(source, 0, dir, 0, source.length);
        return dir;
    }

    public static int[] generate(int size){
        int[] dir = new int[size];
        Random random = new Random();
        for(int i = 0; i< size; i++){
            dir[i] = random.nextInt(size * 10);
        }

        return dir;
    }

    public static void main(String[] args) {


        CaculatePolicy buble = new CaculateBuble();
        CaculatePolicy insert = new CaculateInsert();

        int[] source = generate(400000);

        for(int i = 0 ; i<source.length;i++){
            System.out.print(source[i] + " ");
        }
        System.out.println();


        // buble policy

        long time = System.currentTimeMillis();
//        int[] dirBuble = buble.sort(copyArray(source));
        System.out.println("buble用时："+(System.currentTimeMillis() - time));
//        for(int tmp : dirBuble){
//            System.out.print(tmp+" ");
//        }
        System.out.println();


        // insert policy
        time = System.currentTimeMillis();
        int[] dirInsert = insert.sort(copyArray((source)));
        System.out.println("insert用时："+(System.currentTimeMillis() - time));
//        for(int tmp : dirInsert){
//            System.out.print(tmp+" ");
//        }



    }
}
