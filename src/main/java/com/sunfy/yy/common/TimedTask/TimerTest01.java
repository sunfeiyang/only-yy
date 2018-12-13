package com.sunfy.yy.common.TimedTask;

import java.util.Timer;

/**
 * 指定延迟时间执行定时任务
 */
public class TimerTest01 {
    Timer timer;
    public TimerTest01(int time){
        timer = new Timer();
        timer.schedule(new TimerTaskTest01(), time * 1000);
        //timer.cancel();
    }
    
    public static void main(String[] args) {
        System.out.println("timer begin....");
        new TimerTest01(3);
    }
}

