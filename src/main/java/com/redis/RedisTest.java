package com.redis;


import java.util.*;

public class RedisTest {


    private static String SOURCE_KEY = "COUPON";
    private static RedisService redisService = new RedisService();

    private static void initSource(int i){
        Random random = new Random();
        List array = new ArrayList();
        while(array.size() < i){
            String c = String.valueOf((char)random.nextInt(32));
            if(!array.contains(c)){
               array.add(c);
            }
        }
        redisService.lSet(SOURCE_KEY, array);

    }

    public static void main(String[] args) {
        initSource(10);
    }
}
