package com.utils;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PropertiesUtils extends HashMap<String, String> {

    private String source;
    public PropertiesUtils(String source){
        this.source = source;
        parseProp();
    }

    private void parseProp(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(source)))){
            String line = "";
            while((line = reader.readLine()) != null){
                line = line.trim();
                if(!StringUtils.isEmpty(line) && !line.startsWith("#")){
                    String[] keyValue = line.split("=");
                    if(keyValue.length >= 2){
                        put(keyValue[0].trim(), keyValue[1].trim());
                    }
                }
            }
        }catch (Exception e){
            System.out.println("init properties fail");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        PropertiesUtils utils = new PropertiesUtils("com-model.properties");
        System.out.println(utils.get("redis.host"));

    }


}
