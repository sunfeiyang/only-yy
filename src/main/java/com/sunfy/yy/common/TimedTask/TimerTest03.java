package com.sunfy.yy.common.TimedTask;

import java.util.Timer;

/**
 * 在延迟指定时间后以指定的间隔时间循环执行定时任务
 */
public class TimerTest03 {
    Timer timer;
    
    public TimerTest03(){
        timer = new Timer();
        //线程在延迟特定时间后，间隔固定的时间执行
        timer.schedule(new TimerTaskTest03(), 5000, 1000);
    }
    
    public static void main(String[] args) {
        new TimerTest03();
    }
}

