package com.sunfy.yy.common.TimedTask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 前面Timer在执行定时任务时只会创建一个线程任务，如果存在多个线程，若其中某个线程因为某种原因而导致线程任务执行时间过长，超过了两个任务的间隔时间，会发生一些缺陷：
 */
public class TimerTest04 {
    private Timer timer;
    public long start;   
    
    public TimerTest04(){
        this.timer = new Timer();
        start = System.currentTimeMillis();
    }
    
    public void timerOne(){
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("timerOne invoked ,the time:" + (System.currentTimeMillis() - start));
                try {
                    Thread.sleep(4000);    //线程休眠3000
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1000);
    }
    
    public void timerTwo(){
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("timerOne invoked ,the time:" + (System.currentTimeMillis() - start));
            }
        }, 3000);
    }
    
    public static void main(String[] args) throws Exception {
        TimerTest04 test = new TimerTest04();
        
        test.timerOne();
        test.timerTwo();
    }
}