package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Languages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 语言数据库操作对象
 */
public interface Movie_Languages_Repository extends JpaRepository<Movie_Languages,Integer> {

    //根据subject_id进行过滤
    public ArrayList findBySubjectid(String subjectid);

    //根据subject_id进行过滤
    public ArrayList findBySubjectidAndLanguagesval(String subjectid,String languagesval);
}
