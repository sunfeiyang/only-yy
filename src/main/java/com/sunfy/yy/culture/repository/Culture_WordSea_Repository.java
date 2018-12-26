package com.sunfy.yy.culture.repository;

import com.sunfy.yy.culture.domain.Culture_Famous;
import com.sunfy.yy.culture.domain.Culture_WordSea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 名人名言对应操作数据库的对象
 */
public interface Culture_WordSea_Repository extends JpaRepository<Culture_WordSea,Integer> {
    /*
    自定义查询方法
    注：查询字段和数据库中的字段映射不一致时，查询字段要写对应bean中的字段（反射原理）
        在对应bean中的字段与数据库中字段不一致的映射要通过注解来指定
     */
    //根据Tid过滤
    public Culture_Famous findByTid(Integer tid);
    //Wordseawords(词)过滤Like
    public List findByWordseawordsLike(String keyword);
    //Wordseawords(词)进行过滤，保证数据唯一性
    public Culture_WordSea findByWordseawords(String Wordseawords);

}
