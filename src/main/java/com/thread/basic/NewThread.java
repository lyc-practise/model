package com.thread.basic;

import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的几种方式
 *
 * 一，使用 Runnable 类，创建 Thread 对象，并将 Runnable 类的引用注入
 * 二，直接使用 Thread 类，实现其 run() 方法。一个线程对象只能运行一次，第二次会报 IllegalThreadStateException 异常。不可用的线程状态
 * 三，使用线程池来运行线程，ExecutorService
 *
 * 疑问：
 *  线程不可重复运行，那么线程池是怎么做到线程重复利用的呢？
 *
 */
public class NewThread {

    static class RunTest implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running！");
        }
    }

    static class ThreadTest extends Thread{

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName()+" is running！");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunTest());

        // 第一种创建方式，使用 Runnable 创建 Thread 对象，执行 start() 方法的方式
        thread1.start();

        // 第二种创建方式，直接使用 Thread 的方式，实现Thread的run方法
        Thread thread2 = new ThreadTest();
        thread2.start();
//        thread2.start();     // 第二次运行会报异常，线程的 start 方法为同步方法，有 synchronized 关键字修饰

        // 第三种创建方式，使用线程池 ExecutorService 运行线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName()+" is running！");
        });


    }
}
