package com.sunfy.yy.common.TimedTask;

import com.sunfy.yy.culture.controller.Culture_Allegorical_Controller;
import com.sunfy.yy.common.enums.CultureApiEnum;
import com.sunfy.yy.culture.service.Culture_Allegorical_Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * ScheduledExecutorService 多线程的定时任务
 * 在第一个线程开始后，延时几秒执行，此时第二个在第一个延时过程中执行
 * 第二个线程不会等到第一个执行结束后再执行
 */
public class ScheduledExecutorTest {
    private ScheduledExecutorService scheduExec;
    
    public long start;

    @Autowired
    private Culture_Allegorical_Controller culture_allegorical_controller;
    @Autowired
    private Culture_Allegorical_Service culture_allegorical_service;
    
    public ScheduledExecutorTest(){
        this.scheduExec =  Executors.newScheduledThreadPool(2);
        this.start = System.currentTimeMillis();
    }
    
    public void timerOne(){
        scheduExec.schedule(new Runnable() {
            public void run() {
                System.out.println("timerOne,the time:" + (System.currentTimeMillis() - start));
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },1000,TimeUnit.MILLISECONDS);
    }

    public void timerTwo(){
        scheduExec.schedule(new Runnable() {
            public void run() {
                System.out.println("timerTwo,the time:" + (System.currentTimeMillis() - start));
            }
        },2000, TimeUnit.MILLISECONDS);
    }

    public void timerAllegorical(){
//        scheduExec.schedule(new Runnable() {
//            public void run() {
//                System.out.println("timerPoem开始执行，时间为："+System.currentTimeMillis());
//            }
//        },2000, TimeUnit.MILLISECONDS);
        scheduExec.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("timerAllegorical开始执行，时间为："+System.currentTimeMillis());
                //culture_allegorical_controller.allegoricalRandom();

                String url = CultureApiEnum.ALLEGORICAL_RANDOM.getURL();
                culture_allegorical_service.addAllegoricalRandom(url);
                System.out.println("timerAllegorical执行结束");
            }
        },2000,5000,TimeUnit.MILLISECONDS);
    }
    
    public static void main(String[] args) {
        ScheduledExecutorTest test = new ScheduledExecutorTest();
        test.timerOne();
        test.timerTwo();
    }
}