package com.thread.basic;

import java.util.concurrent.TimeUnit;

/**
 *
 * 不同的线程，同一个run也可以同时运行
 *
 */


public class SameRunTest {

    static class RunTest implements Runnable{

        @Override
        public void run() {

            while(true){
                try{
                    System.out.printf("%s线程运行中....，run对象[%s]\n", Thread.currentThread().getName(), this);
                    TimeUnit.MILLISECONDS.sleep(1000);
                }catch (InterruptedException e){
                    System.out.printf("%s线程终止！", Thread.currentThread().getName());
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable run = new RunTest();

        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);


        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(10000);
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();

    }
}
