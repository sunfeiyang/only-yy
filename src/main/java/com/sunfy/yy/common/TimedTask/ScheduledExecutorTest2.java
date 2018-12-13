package com.sunfy.yy.common.TimedTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest2 {
    private ScheduledExecutorService scheduExec;
    
    public long start;
    
    ScheduledExecutorTest2(){
        this.scheduExec =  Executors.newScheduledThreadPool(2);
        this.start = System.currentTimeMillis();
    }
    
    public void timerOne(){
        //延时执行
        scheduExec.schedule(new Runnable() {
            public void run() {
                System.out.println("线程一开始执行。。。");
                throw new RuntimeException();
            }
        },2000, TimeUnit.MILLISECONDS);
    }
    
    public void timerTwo(){
        //延时周期执行
        scheduExec.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("timerTwo invoked .....");
            }
        },2000,5000,TimeUnit.MILLISECONDS);
    }
    
    public static void main(String[] args) {
        ScheduledExecutorTest2 test = new ScheduledExecutorTest2();
        test.timerOne();
        test.timerTwo();
    }
}