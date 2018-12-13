package com.sunfy.yy.common.TimedTask;

import java.util.TimerTask;

/**
 * 指定延迟时间执行定时任务
 */
public class TimerTaskTest01 extends TimerTask {

    public void run() {
        System.out.println("Time's up!!!!");
    }
}