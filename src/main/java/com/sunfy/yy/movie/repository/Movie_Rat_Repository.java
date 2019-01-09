package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Rat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 影片评分数据库操作对象
 */
public interface Movie_Rat_Repository extends JpaRepository<Movie_Rat,Integer> {

    //根据Tid过滤
    public ArrayList findByTid(String tid);

    //根据subject_id进行过滤
    public ArrayList findBySubjectid(String subjectid);
}
