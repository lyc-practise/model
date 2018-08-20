package com.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * 任务定时机制
 * 分三种
 * 1、在某时刻后执行
 * 2、延时*后执行
 * 3、延时*后每间隔*执行一次
 * 4、第一次在*时执行，之后每间隔*执行一次
 */

public class ManyTimerTask {

    private static Timer timer = new Timer();
    public static class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            try{
                System.out.println("myTimerTask run at "+new Date());
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static class MyOtherTimerTask extends  TimerTask{

        @Override
        public void run() {
            System.out.println("myOtherTimerTask run at "+new Date());
        }
    }

    public static void main(String[] args) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
            Date d1 = format.parse("2018-04-09 21:50:00");
//            Date d2 = format.parse("2018-04-09 21:47:00");
            timer.schedule(new MyTimerTask(), d1);  // 在某时刻后执行
            timer.schedule(new MyOtherTimerTask(), 3000);  // 延时3s执行
            timer.schedule(new MyOtherTimerTask(), 3000, 2000);  //延时3s执行，且每2s执行一次
            timer.schedule(new MyOtherTimerTask(), d1, 2000); // 第一次执行时间是d1，之后间隔2s执行一次
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
