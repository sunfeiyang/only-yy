package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Durations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 影视时长数据库操作对象
 */
public interface Movie_Durations_Repository extends JpaRepository<Movie_Durations,Integer> {

    //根据subject_id进行过滤
    public ArrayList findBySubjectid(String subjectid);

    //根据subject_id进行过滤
    public ArrayList findBySubjectidAndDurationsval(String subjectid,String durationsval);
}
