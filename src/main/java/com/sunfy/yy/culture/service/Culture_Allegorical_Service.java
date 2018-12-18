package com.sunfy.yy.culture.service;

import com.sunfy.yy.culture.domain.Culture_Allegorical;
import com.sunfy.yy.culture.repository.Culture_Allegorical_Repository;
import com.sunfy.yy.culture.utils.EnumRepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Map;

@Service
public class Culture_Allegorical_Service extends Culture_Service{

    //歇后语数据库操作对象
    @Autowired
    private Culture_Allegorical_Repository culture_allegorical_repository;

    private final static Logger logger = LoggerFactory.getLogger(Culture_Allegorical_Service.class);

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    public ArrayList<Culture_Allegorical> addAllegorical(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Allegorical_Service—addAllegorical】请求成功！参数：url="+url);
        }
        return addList(url, EnumRepositoryType.ALLEGORICAL.getRepositoryType());
    }

    public ArrayList<Culture_Allegorical> addAllegoricalRandom(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Allegorical_Service—addAllegoricalRandom】请求成功！参数：url="+url);
        }
        return addRandom(url, EnumRepositoryType.ALLEGORICAL.getRepositoryType());
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Culture_Allegorical mapToBean(Map map){
        //创建要转换的bean对象
        Culture_Allegorical culture_allegorical = new Culture_Allegorical();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        culture_allegorical.setAllegorical_zimu((String) map.get("zimu"));
        culture_allegorical.setAllegoricalanswer((String) map.get("answer"));
        culture_allegorical.setAllegoricalquestion((String) map.get("question"));
        return culture_allegorical;
    }

    /**
     * 对数据进行过滤，移除重复数据
     * @param map 待检查数据
     * @return 返回过滤结果 true：已存在 false：不存在
     */
    public ArrayList listFiltrate(Map map){
        ArrayList result_list = new ArrayList();
        String answer = (String)map.get("answer");
        String question = (String)map.get("question");
        //根据获得到的人名和对应的内容进行过滤，判断内容是否存在，存在返回true，否则返回false
        Culture_Allegorical culture_allegorical = culture_allegorical_repository.findByAllegoricalquestionAndAllegoricalanswer(question,answer);
//        if(culture_allegorical != null){
//            result_list.add(true);
//            result_list.add(culture_allegorical);
//            return result_list;
//        }
        result_list.add(false);
        return result_list;
    }

}
