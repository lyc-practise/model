package com.thread.basic;

import java.util.concurrent.TimeUnit;

/**
 * 线程组测试
 *
 * 测试线程组
 *  1、活跃数量
 *  2、查询状态
 *  3、集体中断
 */
public class ThreadGroupTest {

    static class GroupRun implements Runnable{

        private ThreadGroup threadGroup ;
        private int threadNum;

        public GroupRun(ThreadGroup threadGroup, int threadNum){
            this.threadGroup = threadGroup;
            this.threadNum = threadNum;
        }

        @Override
        public void run() {

            for(int i = 0 ; i < threadNum ; i++){
                Thread thread = new Thread(threadGroup, new Runnable() {
                    @Override
                    public void run() {
                        while(true){
                            try{
                                System.out.printf("线程组[%s]线程[%s]的中断状态为[%s]...\n",
                                        Thread.currentThread().getThreadGroup().getName(),
                                        Thread.currentThread().getName(),
                                        Thread.currentThread().isInterrupted());
                                System.out.printf("线程组[%s]线程[%s]运行中...\n",
                                        Thread.currentThread().getThreadGroup().getName(),
                                        Thread.currentThread().getName());
                                TimeUnit.MILLISECONDS.sleep(2000);
                            }catch (InterruptedException e){
                                System.out.printf("线程组[%s]线程[%s]终止！\n",
                                        Thread.currentThread().getThreadGroup().getName(),
                                        Thread.currentThread().getName());
                                break;
                            }
                        }
                    }
                });

                thread.start();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {


        ThreadGroup  threadGroup = new ThreadGroup("newGroup");
        int threadNum = 7;

        Thread thread = new Thread(new GroupRun(threadGroup, threadNum));
        thread.start();
        addCountListen(threadGroup); // 增加计数监听
        addStateListen(threadGroup); // 增加状态打印监听

        TimeUnit.MILLISECONDS.sleep(2600);

        interruptGroup(threadGroup); // 中断线程组


    }


    public static void addCountListen(ThreadGroup threadGroup){

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true && threadGroup.activeCount() > 0){
                    try{
                        System.out.printf("线程组[%s]活跃数量[%s]\n", threadGroup.getName(), threadGroup.activeCount());
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        System.out.println("activeCount监听终止\n");
                    }
                }
                System.out.println("activeCount监听终止\n");
            }
        });
        t.start();
    }


    public static void addStateListen(ThreadGroup threadGroup){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true && threadGroup.activeCount() > 0){
                    try{
                        Thread[] thread = new Thread[threadGroup.activeCount()];
                        threadGroup.enumerate(thread);
                        for(Thread t : thread){
                            System.out.printf("线程[%s]的状态是:[%s]\n", t.getName(), t.getState().name());
                        }
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        System.out.println("addStateListen监听终止\n");
                    }
                }
                System.out.println("activeCount监听终止\n");
            }
        });
        t.start();

    }

    public static void interruptGroup(ThreadGroup threadGroup){
        threadGroup.interrupt();
    }

}
