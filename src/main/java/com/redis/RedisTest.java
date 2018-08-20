package com.redis;

public class RedisTest {

    public static void main(String[] args){

        RedisService redisService = new RedisService();

        redisService.set("key", "xiaoxiao");


        System.out.println(redisService.get("key"));
    }


}
