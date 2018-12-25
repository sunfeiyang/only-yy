package com.sunfy.yy.culture.repository;

import com.sunfy.yy.culture.domain.Culture_Today_History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 历史上的今天的数据库操作对象
 */
public interface Culture_Today_History_Repository extends JpaRepository<Culture_Today_History,Integer> {
    //根据Tid进行过滤
    public Culture_Today_History findByTid(Integer tid);
    //根据内容进行过滤
    public Culture_Today_History findByTodayhistorytitle(String todayhistorytitle);

    public List findByTodayhistorytitleLike(String keyword);
}
