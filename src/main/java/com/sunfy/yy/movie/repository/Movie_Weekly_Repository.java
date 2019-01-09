package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Weekly;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Weekly数据库操作对象
 */
public interface Movie_Weekly_Repository extends JpaRepository<Movie_Weekly,Integer> {

    //根据Tid过滤
    public Movie_Weekly findByTid(Integer tid);

    //根据subject_id进行过滤
    public Movie_Weekly findBySubjectid(String subjectid);
}
