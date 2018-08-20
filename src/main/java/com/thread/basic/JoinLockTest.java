package com.thread.basic;

import java.util.concurrent.TimeUnit;

/**
 * 测试 join 方法是否会释放锁
 *
 * join 线程获取锁后 join 了run 。但run抛出异常 NullPointerException，后 join 继续运行。
 *
 * 存疑：
 *  是否出现了死锁。
 *  NullPointerException 出现的原因
 */
public class JoinLockTest {

    static class Model{}

    static class Run implements Runnable{
        private Model model ;
        public Run(Model mode){
            this.model = model;
        }

        @Override
        public void run() {
            try {
                System.out.println("run get the model lock and running ....");
                TimeUnit.MILLISECONDS.sleep(300);
                synchronized (model){
                    System.out.println("run get the model lock and running ....");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class JoinLock implements  Runnable{
        private Thread run;
        private Model model;
        public JoinLock(Thread run, Model model){
            this.run = run;
            this.model = model;
        }
        @Override
        public void run(){

            System.out.println("joinLock thread start run");
            synchronized (model){
                System.out.println("joinLock get the lock of model");
                try {
                    run.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("joinLock start run after run thread over");
            }
        }
    }

    public static void main(String[] args) {

        Model model = new Model();

        Thread run = new Thread(new Run(model), "run");
        Thread join = new Thread(new JoinLock(run, model), "join");
        run.start();
        join.start();



    }
}
