package com.thread.basic;

import java.util.Comparator;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * 中断线程
 * 测试对线程的中断
 *
 * 线程中断通过调用 interrupt方法 或者 ExecutorService 的 shutdown 方法来阻断线程
 *
 *
 * 线程有以下状态：
 *  新建
 *  可运行 ，进入到可分配时间片的状态
 *  阻塞 ， 可能因以下原因阻塞
 *      睡眠、join阻塞、I/O阻塞（如等待用户输入）
 *      同步阻塞（锁）
 *      等待阻塞 （wait）
 *  运行
 *  死亡 执行完run方法或因异常退出
 *
 *
 *
 *
 * interrupt()方法只是给目标线程一个中断信号，线程是否能中断还要看线程怎么处理
 *
 * 1、运行中的线程不能被中断，只是收到了中断信号，其中断标志位会置位，调用 isInterrupted() 返回 true。
 *      通过Thread.interrupted() 可以将中断信号复位。
 *
 * 2、在线程不在运行状态时，即没有获取时间片时，如果收到中断信号，因无法处理，所以会抛出 InterruptedException 。
 * 抛出异常不代表程序终止，需要看程序如果处理异常。抛出异常后中断信号也会复位。
 *
 * 3、线程被阻断会在调用 sleep()/join()/wait() 时发生
 *
 *
 */

public class InterruptThread {

    static class RunTest implements Runnable{

        public RunTest(){
            System.out.println("init runtest, the state is new!");
        }

        @Override
        public void run() {
            int count = 0;

            try{
                while(true){
                    System.out.println("执行任务..."+count++);
                    System.out.println("线程中断信号："+Thread.currentThread().isInterrupted());
                    TimeUnit.MILLISECONDS.sleep(2000);
                }
            }catch (InterruptedException e){
                System.out.printf("线程中断异常！线程的中断信号为：[%s]", Thread.currentThread().isInterrupted());
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new RunTest());
        t.start();
        Thread.sleep(200);
        t.interrupt();


    }


}
