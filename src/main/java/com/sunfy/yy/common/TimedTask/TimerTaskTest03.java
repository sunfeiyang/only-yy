package com.sunfy.yy.common.TimedTask;

import java.util.Date;
import java.util.TimerTask;
/**
 * 在延迟指定时间后以指定的间隔时间循环执行定时任务
 */
public class TimerTaskTest03 extends TimerTask {

    @Override
    public void run() {
        Date date = new Date(this.scheduledExecutionTime());
        System.out.println("本次执行该线程的时间为：" + date);
    }
}