package com.sunfy.yy.culture.controller;

import com.sunfy.yy.common.enums.EnumApi;
import com.sunfy.yy.common.utils.UtilsChineseCreat;
import com.sunfy.yy.culture.service.Culture_Today_History_Service;
import com.sunfy.yy.culture.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;

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

    @Autowired
    private Culture_WordSea_Service culture_wordSea_service;

    private Integer sum = 1;

    Date date = new Date();

    /**
     * 随机返回一条（定时任务）
     * @return
     */
//    @Scheduled(cron = "1/55 * * * * *")
//    @Async
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
        /*
        获取RANDOM 随机生成一条的url
         */
        String url_allegorical = EnumApi.ALLEGORICAL_RANDOM.getURL();
        String url_famous = EnumApi.FAMOUS_RANDOM.getURL();
        String url_idiom = EnumApi.IDIOM_RANDOM.getURL();
        String url_poem = EnumApi.POEM_RANDOM.getURL();
        String url_today_history = EnumApi.TODAY_HISTORY.getURL();
        String url_wordsea = EnumApi.WORD_SEA_RANDOM.getURL();

        //随机插入一条
//        culture_allegorical_service.addAllegoricalRandom(url_allegorical);
//        culture_idiom_service.addIdiomRandom(url_idiom);
//        culture_poem_service.addPoemRandom(url_poem);
//        culture_wordSea_service.addRandom(url_wordsea);
//        culture_famous_service.addFamousRandom(url_famous);
//        if(sum <= 55){
//            culture_famous_service.addFamousRandom(url_famous);
//        }

        /*
        获取批量数据插入链接
         */
        String url_wordsea_list = EnumApi.WORD_SEA.getURL();
        url_wordsea_list += "&keyword="+ UtilsChineseCreat.getRandomChar()+"&page=1&rows=50";

        String url_idiom_list = EnumApi.IDIOM.getURL();
        url_idiom_list += "&keyword="+ UtilsChineseCreat.getRandomChar()+"&page=1&rows=50";

        String url_famous_list = EnumApi.FAMOUS.getURL();
        url_famous_list += "&keyword="+ UtilsChineseCreat.getRandomChar()+"&page=1&rows=50";

        String url_poem_list = EnumApi.POEM.getURL();
        url_poem_list += "&keyword="+ UtilsChineseCreat.getRandomChar()+"&page=1&rows=50";

        String url_allegorical_list = EnumApi.ALLEGORICAL.getURL();
        url_allegorical_list += "&keyword="+ UtilsChineseCreat.getRandomChar()+"&page=1&rows=50";

        /*
        处理历史上的今天数据
         */
//        int month = UtilsDate.getCurrentDayMM(date);
//        int day = UtilsDate.getCurrentDayDD(date);
//        url_today_history += "&yue="+month;
//        url_today_history += "&ri="+day;
//        if(sum%2 == 1){
//            url_today_history += "&type=1";
//            System.out.println("获取数据为【国内国际大事件】");
//        }else {
//            url_today_history += "&type=2";
//            System.out.println("获取数据为【民间事件包含部分国家大事件】");
//            //两个事件获取完成后加一天
////            int num = 1;
////            if(month == 12){
////                num = 199;
////            }
//            date = UtilsDate.addDays(date,-1);
//        }
//        url_today_history += "&page=1&rows=50";
//
//        System.out.println("获得的日期为：【"+month+"】月【"+day+"】日");

        String url_dic = EnumApi.DIC.getURL();
        String str1 = "";
        for (int i = 0; i < 100; i++) {
            str1 += UtilsChineseCreat.getRandomHan();
        }
        url_dic += "&content="+str1;
        System.out.println("获得的汉字为：【"+str1+"】");


//      culture_today_history_service.addToday_History(url_today_history);
        culture_dic_service.addDic(url_dic);
        culture_wordSea_service.addList(url_wordsea_list);
        culture_idiom_service.addIdiomList(url_idiom_list);
//        if(sum <= 99){
            culture_famous_service.addFamous(url_famous_list);
//        }
        culture_poem_service.addPoemList(url_poem_list);
        culture_allegorical_service.addAllegorical(url_allegorical_list);

        //记录执行次数（每次启动后初始为 0 ）
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Controller—CultureRandom】定时任务已执行：【"+ sum++ +"次】");
        }

    }
}
