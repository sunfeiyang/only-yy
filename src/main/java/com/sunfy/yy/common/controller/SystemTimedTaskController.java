package com.sunfy.yy.common.controller;

import com.sunfy.yy.common.TimedTask.ScheduledExecutorTest;
import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文学辞典定时任务控制器
 */
@RestController
public class SystemTimedTaskController {

    private static final Logger logger = LoggerFactory.getLogger(SystemTimedTaskController.class);

    //定时任务执行对象
    ScheduledExecutorTest scheduledExecutorTest = new ScheduledExecutorTest();

//    @GetMapping(value = "timedTask/cultural/AllegoricalRandom/{disabled}")
//    public Result TimedTask_Allegorical(@PathVariable("disabled") String disabled){
//        if ("true".equals(disabled)){
//            scheduledExecutorTest.timerAllegorical();
//            return ResultUtil.success("定时任务启动成功！");
//        }else{
//            return ResultUtil.error(500,"定时任务已关闭！");
//        }
//
//    }
}
