package com.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanUtils {

    private static ThreadLocal<ApplicationContext> contextTL = new ThreadLocal();

    public static ApplicationContext getContext(){
        ApplicationContext context = contextTL.get();
        if(context == null){
            context = new FileSystemXmlApplicationContext("classpath:spring/applicationContext.xml");
            contextTL.set(context);
        }
        return context;
    }

    public static <T> T getBean(String name){
        return (T)getContext().getBean(name);
    }
}
