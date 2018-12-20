package com.sunfy.yy.culture.service.Impl;

import com.sunfy.yy.culture.domain.Culture_Famous;
import com.sunfy.yy.culture.service.Culture_Famous_Service;
import com.sunfy.yy.common.enums.EnumRepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Map;

@Service
public class Culture_Famous_ServiceImpl extends Culture_ServiceImpl implements Culture_Famous_Service {

    private final static Logger logger = LoggerFactory.getLogger(Culture_Famous_ServiceImpl.class);

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    @Override
    public ArrayList addFamous(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Famous_Service—addFamous】请求成功！参数：url="+url);
        }
        return addList(url, EnumRepositoryType.FAMOUS.getRepositoryType());
    }

    @Override
    public ArrayList addFamousRandom(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Famous_Service—addFamousRandom】请求成功！参数：url="+url);
        }
        return addRandom(url, EnumRepositoryType.FAMOUS.getRepositoryType());
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Culture_Famous mapToBean(Map map){
        //创建要转换的bean对象
        Culture_Famous culture_famous = new Culture_Famous();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        culture_famous.setFamousname((String) map.get("famous_name"));
        culture_famous.setFamoussaying((String) map.get("famous_saying"));
        return culture_famous;
    }
}
