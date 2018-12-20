package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_In_Theaters;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 即将热映数据库操作对象
 */
public interface Movie_In_Theaters_Repository extends JpaRepository<Movie_In_Theaters,Integer> {

    //根据Tid过滤
    public Movie_In_Theaters findByTid(Integer tid);

    //根据subject_id进行过滤
    public Movie_In_Theaters findBySubjectid(String subjectid);
}
