package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Prevue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 预告片数据库操作对象
 */
public interface Movie_Prevue_Repository extends JpaRepository<Movie_Prevue,Integer> {

    //根据subject_id进行过滤
    public ArrayList findBySubjectid(String subjectid);

    //Prevueid
    public ArrayList findByPrevueid(String prevueid);

    //Prevueid&subject_id
    public ArrayList findByPrevueidAndSubjectid(String prevueid, String subjectid);
}
