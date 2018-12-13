package com.sunfy.yy.common.TimedTask;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
/**
 * 在指定时间执行定时任务
 */
public class TimerTest02 {
    Timer timer;
    
    public TimerTest02(){
        Date time = getTime();
        System.out.println("指定时间time=" + time);
        timer = new Timer();
        timer.schedule(new TimerTaskTest02(), time);
    }
    
    public Date getTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 17);
        calendar.set(Calendar.SECOND, 00);
        Date time = calendar.getTime();
        
        return time;
    }
    
    public static void main(String[] args) {
        new TimerTest02();
    }
}

