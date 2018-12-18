package com.sunfy.yy.culture.service;

import com.sunfy.yy.common.utils.HttpRequest;
import com.sunfy.yy.culture.domain.Culture_Today_History;
import com.sunfy.yy.culture.repository.Culture_Today_History_Repository;
import com.sunfy.yy.culture.utils.EnumRepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Map;

@Service
public class Culture_Today_History_Service extends Culture_Service{

    //历史上的今天数据库操作对象
    @Autowired
    private Culture_Today_History_Repository culture_today_history_repository;

    //发送http请求的对象
    HttpRequest httpRequest = new HttpRequest();

    private final static Logger logger = LoggerFactory.getLogger(Culture_Today_History_Service.class);

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    public ArrayList addToday_History(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Today_History_Service—addToday_History】请求成功！参数：url="+url);
        }
        return addList(url, EnumRepositoryType.TODAY_HISTORY.getRepositoryType());
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Culture_Today_History mapToBean(Map map){
        //创建要转换的bean对象
        Culture_Today_History culture_today_history = new Culture_Today_History();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        culture_today_history.setToday_history_day((Integer) map.get("day"));
        culture_today_history.setToday_history_year((Integer) map.get("year"));
        culture_today_history.setToday_history_month((Integer) map.get("month"));
        culture_today_history.setTodayhistorytitle((String) map.get("title"));
        culture_today_history.setToday_history_type((Integer) map.get("type"));
        return culture_today_history;
    }

    /**
     * 对数据进行过滤，移除重复数据
     * @param map 待检查数据
     * @return 返回过滤结果 true：已存在 false：不存在
     */
    public ArrayList listFiltrate(Map map){
        ArrayList result_list = new ArrayList();
        String title = (String)map.get("title");
        //根据获得到的人名和对应的内容进行过滤，判断内容是否存在，存在返回true，否则返回false
        Culture_Today_History culture_today_history = culture_today_history_repository.findByTodayhistorytitle(title);
        if(culture_today_history != null){
            result_list.add(true);
            result_list.add(culture_today_history);
            return result_list;
        }
        result_list.add(false);
        return result_list;
    }

}
