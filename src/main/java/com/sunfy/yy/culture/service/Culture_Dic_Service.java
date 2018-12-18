package com.sunfy.yy.culture.service;

import com.sunfy.yy.culture.domain.Culture_Dic;
import com.sunfy.yy.culture.repository.Culture_Dic_Repository;
import com.sunfy.yy.culture.utils.EnumRepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Map;

@Service
public class Culture_Dic_Service extends Culture_Service{

    //字典数据库操作对象
    @Autowired
    private Culture_Dic_Repository culture_Dic_repository;

    private final static Logger logger = LoggerFactory.getLogger(Culture_Dic_Service.class);

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
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

    /**
     * 对数据进行过滤，移除重复数据
     * @param map 待检查数据
     * @return 返回过滤结果 true：已存在 false：不存在
     */
    public ArrayList listFiltrate(Map map){
        ArrayList result_list = new ArrayList();
        String hanzi = (String)map.get("hanzi");
        //根据获得到的内容进行过滤，判断内容是否存在，存在返回true，否则返回false
        Culture_Dic culture_dic = culture_Dic_repository.findByDichanzi(hanzi);
        if(culture_dic != null){
            result_list.add(true);
            result_list.add(culture_dic);
            return result_list;
        }
        result_list.add(false);
        return result_list;
    }

}
