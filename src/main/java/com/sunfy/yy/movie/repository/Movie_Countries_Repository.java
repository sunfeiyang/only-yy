package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Countries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 国别数据库操作对象
 */
public interface Movie_Countries_Repository extends JpaRepository<Movie_Countries,Integer> {

    //根据subject_id过滤
    public ArrayList findBySubjectid(String subjectid);

    //根据subject_id和国别进行过滤
    public ArrayList findBySubjectidAndCountriesval(String subjectid,String countriesval);
}
