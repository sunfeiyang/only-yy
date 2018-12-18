package com.sunfy.yy.culture.repository;

import com.sunfy.yy.culture.domain.Culture_Famous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 名人名言对应操作数据库的对象
 */
public interface Culture_Famous_Repository extends JpaRepository<Culture_Famous,Integer> {
    /*
    自定义查询方法
    注：查询字段和数据库中的字段映射不一致时，查询字段要写对应bean中的字段（反射原理）
        在对应bean中的字段与数据库中字段不一致的映射要通过注解来指定
     */
    //根据Tid过滤
    public Culture_Famous findByTid(Integer tid);
    //根据famousname(人名)过滤——》数据库中映射的字段数据FAMOUS_NAME
    public List<Culture_Famous> findByFamousname(String famousname);
    //根据famoussaying(内容)过滤
    public List<Culture_Famous> findByFamoussaying(String famoussaying);
    //根据famousname(人名)和famoussaying(内容)同时进行过滤，保证数据唯一性
    public Culture_Famous findByFamousnameAndFamoussaying(String famousname,String famoussaying);

}
