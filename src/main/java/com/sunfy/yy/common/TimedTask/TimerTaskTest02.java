package com.sunfy.yy.common.TimedTask;

import java.util.TimerTask;

/**
 * 在指定时间执行定时任务
 */
public class TimerTaskTest02 extends TimerTask {

    @Override
    public void run() {
        System.out.println("指定时间执行线程任务...");
    }
}