package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 影片详情数据库操作对象
 */
public interface Movie_Subject_Repository extends JpaRepository<Movie_Subject,Integer> {

    //根据Tid过滤
    public ArrayList findByTid(String tid);

    //根据subject_id进行过滤
    public ArrayList findBySubjectid(String subjectid);
}
