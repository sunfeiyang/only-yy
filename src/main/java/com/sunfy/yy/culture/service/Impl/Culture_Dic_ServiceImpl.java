package com.sunfy.yy.culture.service.Impl;

import com.sunfy.yy.culture.domain.Culture_Dic;
import com.sunfy.yy.culture.service.Culture_Dic_Service;
import com.sunfy.yy.culture.utils.EnumRepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Map;

@Service
public class Culture_Dic_ServiceImpl extends Culture_ServiceImpl implements Culture_Dic_Service {

    private final static Logger logger = LoggerFactory.getLogger(Culture_Dic_ServiceImpl.class);

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    @Override
    public ArrayList addDic(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Dic_Service—addDic】请求成功！参数：url="+url);
        }
        return addList(url, EnumRepositoryType.DIC.getRepositoryType());
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Culture_Dic mapToBean(Map map){
        //创建要转换的bean对象
        Culture_Dic culture_dic = new Culture_Dic();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        culture_dic.setDichanzi((String)map.get("hanzi"));
        culture_dic.setDic_pinyin((String)map.get("pinyin"));
        culture_dic.setDic_duyin((String)map.get("duyin"));
        culture_dic.setDic_bushou((String)map.get("bushou"));
        culture_dic.setDic_bihua((Integer)map.get("bihua"));
        culture_dic.setDic_jianjie((String)map.get("jianjie"));
        culture_dic.setDic_xiangjie((String)map.get("xiangjie"));
        return culture_dic;
    }

}
