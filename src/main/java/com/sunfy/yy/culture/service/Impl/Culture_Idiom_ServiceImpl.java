package com.sunfy.yy.culture.service.Impl;

import com.sunfy.yy.common.enums.EnumApi;
import com.sunfy.yy.culture.domain.Culture_Idiom;
import com.sunfy.yy.culture.service.Culture_Idiom_Service;
import com.sunfy.yy.common.enums.EnumRepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Map;

@Service
public class Culture_Idiom_ServiceImpl extends Culture_ServiceImpl implements Culture_Idiom_Service {

    private final static Logger logger = LoggerFactory.getLogger(Culture_Idiom_ServiceImpl.class);

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    @Override
    public ArrayList addIdiomList(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Idiom_Service—addIdiomList】请求成功！参数：url="+url);
        }
        String urlDetails = EnumApi.IDIOM_DETAILS.getURL();
        return addDetailsList(url,urlDetails,EnumRepositoryType.IDIOM.getRepositoryType());
    }

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    @Override
    public ArrayList addIdiom(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Idiom_Service—addIdiom】请求成功！参数：url="+url);
        }
        return addList(url, EnumRepositoryType.IDIOM.getRepositoryType());
    }

    @Override
    public ArrayList<Culture_Idiom> addIdiomRandom(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Idiom_Service—addIdiomRandom】请求成功！参数：url="+url);
        }
        return addRandom(url, EnumRepositoryType.IDIOM.getRepositoryType());
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Culture_Idiom mapToBean(Map map){
        //创建要转换的bean对象
        Culture_Idiom culture_idiom = new Culture_Idiom();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        culture_idiom.setIdiomid((String) map.get("id"));
        culture_idiom.setIdiomname((String) map.get("name"));
        culture_idiom.setIdiom_spell((String) map.get("spell"));
        culture_idiom.setIdiom_content((String) map.get("content"));
        culture_idiom.setIdiom_derivation((String) map.get("derivation"));
        culture_idiom.setIdiom_samples((String) map.get("samples"));
        return culture_idiom;
    }
}
