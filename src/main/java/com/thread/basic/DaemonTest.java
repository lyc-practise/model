package com.thread.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 守护线程测试 daemon， 默认非守护线程，setDaemon(true)后为守护线程，set 需在 start 之前做。
 * 线程分为 user 线程 和 daemon线程，即用户线程和守护线程
 *
 * 主线程（main）结束的时候会创建 DestroyJavaVM 线程，DestroyJavaVM线程会在 user 线程都退出后退出。类 daemon线程。但不知是否为 daemon 线程。
 *
 *守护线程和被user线程的区别是：
 *  如果被守护者不在进行，那么守护线程也跟着死亡
 *  守护线程的子线程也是守护线程
 *
 *守护线程不只守护创建它的线程，也守护别的user线程。哪怕是其他group的线程。在所有user线程结束后，守护进程自动结束
 * 如果守护线程的任务完成，也会结束
 *
 *ExecutorService 会把守护线程变成非守护线程。
 *
 *
 *守护线程一般不要用作资源读取等，因不知何时会down掉。尽量使用user线程，如果要终止线程，可以用interrupt
 *
 */

public class DaemonTest {

    static class DaemonRun implements Runnable{
        private long sleepTime;
        public DaemonRun(long sleepTime){
            this.sleepTime = sleepTime;
        }

        public void run(){
            while(true){
                try{
                    System.out.println("daemon线程运行中...");
                    TimeUnit.MILLISECONDS.sleep(sleepTime);
                }catch (InterruptedException e){
                    System.out.println("后台线程中断...！");
                }
            }
        }
    }

    static class RunTest implements Runnable{

        private long sleep ;

        public RunTest(){
            System.out.println("初始化任务！");
        }
        public RunTest(long sleep){
            this.sleep = sleep;
            System.out.println("初始化任务！");
        }

        @Override
        public void run() {

            String name = Thread.currentThread().getName();
            System.out.println("线程[" + name + "]任务开始");
            System.out.println("线程[" + name + "]是否为daemon线程："+Thread.currentThread().isDaemon());
            System.out.println("线程[" + name + "]属于线程组【");
            System.out.println("[" + name + "]是否是守护线程："+Thread.currentThread().isDaemon());
            try{
                System.out.println("[" + name + "]睡眠前当前线程组活跃线程："+Thread.activeCount());
                Thread.sleep(sleep);
                System.out.println("[" + name + "]睡眠后当前线程组活跃线程："+Thread.activeCount());
                Thread.currentThread().getThreadGroup().list();
                System.out.println("[" + name + "]睡眠结束，继续执行");
            }catch (InterruptedException e){
                System.out.println("[" + name + "]线程被打断");
            }
        }
    }

    public static void noDaemon(long sleepTime){
        Thread thread = new Thread(new RunTest(sleepTime));
        thread.setName("ThreaddefaultDaemon");
        thread.start();
    }

    public static void noDaemonOtherGroup(long sleepTime){
        ThreadGroup group = new ThreadGroup("newGroup");
        Thread thread = new Thread(group,new RunTest(sleepTime));
        thread.setName("ThreaddefaultDaemon");
        thread.start();
    }

    public static void daemon(long sleepTime){
        Thread thread = new Thread(new DaemonRun(sleepTime));
        thread.setDaemon(true);
        thread.setName("ThreadisDaemon");
        thread.start();
    }

    public static void executorDaemon(long sleepTime){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread thread = new Thread(new DaemonRun(sleepTime));
        thread.setDaemon(true);
        executorService.execute(thread);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("当前活跃线程数："+Thread.activeCount());
        Thread.currentThread().getThreadGroup().list();


        daemon(1000);
        noDaemonOtherGroup(6000);
//        executorDaemon(2000);

        System.out.println("睡眠结束111");

    }



}
