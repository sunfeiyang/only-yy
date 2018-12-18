package com.sunfy.yy.culture.controller;

import com.sunfy.yy.common.enums.EnumCultureApi;
import com.sunfy.yy.culture.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * Culture中全局的控制器
 */
@Controller
public class Culture_Controller {

    private static final Logger logger = LoggerFactory.getLogger(Culture_Controller.class);

    @Autowired
    private Culture_Allegorical_Service culture_allegorical_service;

    @Autowired
    private Culture_Dic_Service culture_dic_service;

    @Autowired
    private Culture_Famous_Service culture_famous_service;

    @Autowired
    private Culture_Idiom_Service culture_idiom_service;

    @Autowired
    private Culture_Poem_Service culture_poem_service;

    @Autowired
    private Culture_Today_History_Service culture_today_history_service;

    private Integer sum = 1;

    /**
     * 随机返回一条（定时任务）
     * @return
     */
    @Scheduled(cron = "1 * * * * *")
    @Async
    /*
    在上面的定时任务中，我们在方法上使用@Scheduled注解来设置任务的执行时间，并且使用三种属性配置方式：

        fixedRate：定义一个按一定频率执行的定时任务  @Scheduled(fixedRate = 5000)
        fixedDelay：定义一个按一定频率执行的定时任务，与上面不同的是，改属性可以配合initialDelay， 定义该任务延迟执行时间。 @Scheduled(fixedDelay = 5000)
        cron：通过表达式来配置任务执行时间 @Scheduled(cron = "0/5 * * * * *")

     @Async 每一个任务都是在不同的线程中
     */
    public void CultureRandom(){
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Controller—CultureRandom】定时任务执行中...");
        }
        String url_allegorical = EnumCultureApi.ALLEGORICAL_RANDOM.getURL();
        String url_famous = EnumCultureApi.FAMOUS_RANDOM.getURL();
        String url_idiom = EnumCultureApi.IDIOM_RANDOM.getURL();
        String url_poem = EnumCultureApi.POEM_RANDOM.getURL();
        //执行任务
        culture_allegorical_service.addAllegoricalRandom(url_allegorical);
        culture_famous_service.addFamousRandom(url_famous);
        culture_idiom_service.addIdiomRandom(url_idiom);
        culture_poem_service.addPoemRandom(url_poem);

        //记录执行次数（每次启动后初始为 0 ）
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Controller—CultureRandom】定时任务已执行：【"+ sum++ +"次】");
        }

    }
}
