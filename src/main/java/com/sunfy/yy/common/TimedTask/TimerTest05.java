package com.sunfy.yy.common.TimedTask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 设置同一个线程需要在同一个时间执行两个不同的任务，导致出现RuntimeException异常
 * 会导致定时任务报错，终止执行
 */
public class TimerTest05 {
    private Timer timer;
    
    public TimerTest05(){
        this.timer = new Timer();
    }
    
    public void timerOne(){
        timer.schedule(new TimerTask() {
            public void run() {
                throw new RuntimeException();
            }
        }, 1000);
    }
    
    public void timerTwo(){
        timer.schedule(new TimerTask() {
            
            public void run() {
                System.out.println("我会不会执行呢？？");
            }
        }, 1000);
    }
    
    public static void main(String[] args) {
        TimerTest05 test = new TimerTest05();
        test.timerOne();
        test.timerTwo();
    }
}