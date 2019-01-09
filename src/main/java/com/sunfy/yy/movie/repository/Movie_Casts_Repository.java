package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Casts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 演职员数据库操作对象
 */
public interface Movie_Casts_Repository extends JpaRepository<Movie_Casts,Integer> {

    //根据subject_id进行过滤
    public ArrayList findBySubjectid(String subjectid);

    //castsid
    public ArrayList findByCastsid(String castsid);

    //castsid&subject_id
    public ArrayList findByCastsidAndSubjectid(String castsid, String subjectid);
}
