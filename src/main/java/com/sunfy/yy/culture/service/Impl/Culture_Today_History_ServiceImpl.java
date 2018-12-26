package com.sunfy.yy.culture.service.Impl;

import com.sunfy.yy.culture.domain.Culture_Today_History;
import com.sunfy.yy.culture.service.Culture_Today_History_Service;
import com.sunfy.yy.common.enums.EnumRepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Culture_Today_History_ServiceImpl extends Culture_ServiceImpl implements Culture_Today_History_Service {

    private final static Logger logger = LoggerFactory.getLogger(Culture_Today_History_ServiceImpl.class);

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    @Override
    public ArrayList addToday_History(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Today_History_Service—addToday_History】请求成功！参数：url="+url);
        }
        return addList(url, EnumRepositoryType.TODAY_HISTORY.getRepositoryType());
    }

    @Override
    public ArrayList selLikeList(Map map) {
        return selLikeList(map,EnumRepositoryType.TODAY_HISTORY.getRepositoryType());
    }

    @Override
    public List selListPage(Map map) {
        return selListPage(map,EnumRepositoryType.TODAY_HISTORY.getRepositoryType());
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
        if((String) map.get("title") == null){
            culture_today_history.setTodayhistorytitle("无内容");
        }else{
            culture_today_history.setTodayhistorytitle((String) map.get("title"));
        }
        culture_today_history.setToday_history_type((Integer) map.get("type"));
        return culture_today_history;
    }

}
