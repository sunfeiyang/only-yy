package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Top250;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Top250数据库操作对象
 */
public interface Movie_Top250_Repository extends JpaRepository<Movie_Top250,Integer> {

    //根据Tid过滤
    public Movie_Top250 findByTid(Integer tid);

    //根据subject_id进行过滤
    public Movie_Top250 findBySubjectid(String subjectid);
}
