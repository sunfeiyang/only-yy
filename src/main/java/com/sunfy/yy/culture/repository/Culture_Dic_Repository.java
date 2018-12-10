package com.sunfy.yy.culture.repository;

import com.sunfy.yy.culture.domain.Culture_Dic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 字典对应操作数据库的对象
 */
public interface Culture_Dic_Repository extends JpaRepository<Culture_Dic,Integer> {
    //根据Tid过滤
    public List<Culture_Dic> findByTid(Integer tid);
    //根据Dichanzi(字)过滤——》数据库中映射的字段数据Dic_hanzi
    public List<Culture_Dic> findByDichanzi(String Dichanzi);

}
