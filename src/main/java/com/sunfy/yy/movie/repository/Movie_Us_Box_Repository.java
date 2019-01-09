package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Us_Box;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 欧美票房榜数据库操作对象
 */
public interface Movie_Us_Box_Repository extends JpaRepository<Movie_Us_Box,Integer> {

    //根据Tid过滤
    public Movie_Us_Box findByTid(Integer tid);

    //根据subject_id进行过滤
    public Movie_Us_Box findBySubjectid(String subjectid);
}
