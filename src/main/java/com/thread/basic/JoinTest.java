package com.thread.basic;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * join 方法是将被调用线程插入当前线程，当前线程需等join进来的线程执行完或一定时间后才可以继续执行。
 * 一旦调用join方法，当前线程即进行 TIMED_WAITING 状态。
 */
public class JoinTest {

    static class Run implements  Runnable{

        @Override
        public void run() {
            try{
                System.out.printf("run thread is starting \n");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("run sleep 2s over");
            }catch (InterruptedException e){
                System.out.printf("run stop!\n");
            }
        }
    }

    static class Join implements  Runnable{

        @Override
        public void run() {
            try{
                System.out.printf("join thread is starting \n");
                TimeUnit.SECONDS.sleep(7);
                System.out.println("join thread sleep 6s over");
            }catch (InterruptedException e){
                System.out.printf("join thread stop!\n");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread run = new Thread(new Run() , "run");
        Thread join = new Thread(new Join(), "join");

        run.start();
        join.start();
        System.out.println("main is running, and run & join start, time is "+(new Date()));
        run.join(3000);
        System.out.println("main is running, and run & join start, time is "+(new Date()));
        join.join();
        System.out.println("main is over, time is "+(new Date()));

    }
}
