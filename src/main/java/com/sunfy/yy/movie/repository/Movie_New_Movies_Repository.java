package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_New_Movies;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 新片数据库操作对象
 */
public interface Movie_New_Movies_Repository extends JpaRepository<Movie_New_Movies,Integer> {

    //根据Tid过滤
    public Movie_New_Movies findByTid(Integer tid);

    //根据subject_id进行过滤
    public Movie_New_Movies findBySubjectid(String subjectid);
}
