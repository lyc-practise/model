package com.thread.basic;

import com.utils.DateUtils;
import com.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDaemon {

    private static Timer timer = new Timer(true);

    static class Task extends TimerTask{

        @Override
        public void run() {
            System.out.println("task runing");
        }
    }

    public static void main(String[] args) {
        String runDate = "2018-04-12 22:47:00";
        Date d = Utils.parseDateTime(runDate);

        try{
            TimerTask task = new Task();
            timer.schedule(task, d);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
