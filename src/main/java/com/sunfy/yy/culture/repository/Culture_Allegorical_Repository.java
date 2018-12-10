package com.sunfy.yy.culture.repository;

import com.sunfy.yy.culture.domain.Culture_Allegorical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 歇后语数据库操作对象
 */
public interface Culture_Allegorical_Repository extends JpaRepository<Culture_Allegorical,Integer> {
    //根据Tid过滤
    public List<Culture_Allegorical> findByTid(Integer tid);
    //根据歇后语前后内容过滤（唯一性过滤）
    public List<Culture_Allegorical> findByAllegoricalquestionAndAllegoricalanswer(String allegoricalquestion,String allegoricalanswer);
}
