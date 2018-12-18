package com.sunfy.yy.culture.service.Impl;

import com.sunfy.yy.common.enums.EnumCultureApi;
import com.sunfy.yy.culture.domain.Culture_Poem;
import com.sunfy.yy.culture.service.Culture_Poem_Service;
import com.sunfy.yy.culture.utils.EnumRepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Map;

@Service
public class Culture_Poem_ServiceImpl extends Culture_ServiceImpl implements Culture_Poem_Service {

    private final static Logger logger = LoggerFactory.getLogger(Culture_Poem_ServiceImpl.class);

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    @Override
    public ArrayList addPoemList(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Poem_Service—addPoemList】请求成功！参数：url="+url);
        }
        String urlDetails = EnumCultureApi.POEM_DETAILS.getURL();
        return addDetailsList(url,urlDetails,EnumRepositoryType.POEM.getRepositoryType());
    }

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    @Override
    public ArrayList addPoem(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Poem_Service—addPoem】请求成功！参数：url="+url);
        }
        return addList(url, EnumRepositoryType.POEM.getRepositoryType());
    }

    //事务操作 防止多条数据插入时 有失败情况
    @Override
    public ArrayList<Culture_Poem> addPoemRandom(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Poem_Service—addPoemRandom】请求成功！参数：url="+url);
        }
        return addRandom(url, EnumRepositoryType.POEM.getRepositoryType());
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Culture_Poem mapToBean(Map map){
        //创建要转换的bean对象
        Culture_Poem culture_poem = new Culture_Poem();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        culture_poem.setPoem_id((String) map.get("id"));
        culture_poem.setPoembiaoti((String) map.get("biaoti"));
        culture_poem.setPoem_jieshao((String) map.get("jieshao"));
        culture_poem.setPoemzuozhe((String) map.get("zuozhe"));
        culture_poem.setPoemneirong((String) map.get("neirong"));
        return culture_poem;
    }

}
