package com.sunfy.yy.culture.repository;

import com.sunfy.yy.culture.domain.Culture_Idiom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 成语操作数据库对象
 */
public interface Culture_Idiom_Repository extends JpaRepository<Culture_Idiom,Integer> {
    //根据tid进行过滤
    public Culture_Idiom findByTid(Integer tid);
    //根据idiomname过滤
    public List<Culture_Idiom> findByIdiomnameLike(String idiomname);
    //根据id过滤
    public Culture_Idiom findByIdiomid(String idiomid);
}
