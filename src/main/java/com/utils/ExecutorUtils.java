package com.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorUtils {

    private static ThreadPoolTaskExecutor executor ;
    private static Logger LOGGER = LoggerFactory.getLogger(ExecutorUtils.class);

    public static void execute(Runnable runnable){
        executor.submit(runnable);
    }

    public static <V> Future<V> execute(Callable<V> call){
        return executor.submit(call);
    }

    public static void print(){
        System.out.println("abc");
    }

    public static void setExecutor(ThreadPoolTaskExecutor executor) {
        ExecutorUtils.executor = executor;
    }
}
