package com.sunfy.yy.culture.service.Impl;

import com.sunfy.yy.common.enums.EnumRepositoryType;
import com.sunfy.yy.culture.domain.Culture_Famous;
import com.sunfy.yy.culture.domain.Culture_WordSea;
import com.sunfy.yy.culture.service.Culture_Famous_Service;
import com.sunfy.yy.culture.service.Culture_WordSea_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Culture_WordSea_ServiceImpl extends Culture_ServiceImpl implements Culture_WordSea_Service {

    private final static Logger logger = LoggerFactory.getLogger(Culture_WordSea_ServiceImpl.class);

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    @Override
    public ArrayList addList(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_WordSea_ServiceImpl—addList】请求成功！参数：url="+url);
        }
        return addList(url, EnumRepositoryType.WORD_SEA.getRepositoryType());
    }

    @Override
    public ArrayList addRandom(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_WordSea_ServiceImpl—addFamousRandom】请求成功！参数：url="+url);
        }
        return addRandom(url, EnumRepositoryType.WORD_SEA.getRepositoryType());
    }

    @Override
    public ArrayList selLikeList(Map map) {
        return selLikeList(map,EnumRepositoryType.WORD_SEA.getRepositoryType());
    }

    @Override
    public List selListPage(Map map) {
        return selListPage(map,EnumRepositoryType.WORD_SEA.getRepositoryType());
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Culture_WordSea mapToBean(Map map){
        //创建要转换的bean对象
        Culture_WordSea culture_wordSea = new Culture_WordSea();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        culture_wordSea.setWordseawords((String) map.get("words"));
        culture_wordSea.setWordseacontent((String) map.get("content"));
        return culture_wordSea;
    }
}
