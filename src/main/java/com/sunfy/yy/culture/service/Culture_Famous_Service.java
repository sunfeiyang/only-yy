package com.sunfy.yy.culture.service;

import com.sunfy.yy.common.enums.EnumCultureException;
import com.sunfy.yy.common.exception.ExceptionCulture;
import com.sunfy.yy.culture.domain.Culture_Famous;
import com.sunfy.yy.culture.repository.Culture_Famous_Repository;
import com.sunfy.yy.culture.utils.EnumRepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Map;

@Service
public class Culture_Famous_Service extends Culture_Service{

    //名人名言数据库操作对象
    @Autowired
    private Culture_Famous_Repository culture_famous_repository;

    private final static Logger logger = LoggerFactory.getLogger(Culture_Famous_Service.class);

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    public ArrayList addFamous(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Famous_Service—addFamous】请求成功！参数：url="+url);
        }
        return addList(url, EnumRepositoryType.FAMOUS.getRepositoryType());
    }

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

    /**
     * 对数据进行过滤，移除重复数据
     * @param map 待检查数据
     * @return 返回过滤结果 true：已存在 false：不存在
     */
    public ArrayList listFiltrate(Map map){
        ArrayList result_list = new ArrayList();
        String famous_name = "";
        String famous_saying = "";
        if(map != null){
            famous_name = (String)map.get("famous_name");
            famous_saying = (String)map.get("famous_saying");
        }else{
            throw new ExceptionCulture(EnumCultureException.ERROR);
        }
        Culture_Famous culture_famous = null;
        if(famous_name != "" && famous_name != null && famous_saying != "" && famous_saying != null){
            //根据获得到的人名和对应的内容进行过滤，判断内容是否存在，存在返回true，否则返回false
            culture_famous = culture_famous_repository.findByFamousnameAndFamoussaying(famous_name,famous_saying);
        }else{
            result_list.add(true);
            result_list.add(culture_famous);
            return result_list;
        }
        if(culture_famous != null){
            result_list.add(true);
            result_list.add(culture_famous);
            return result_list;
        }
        result_list.add(false);
        return result_list;
    }
}
