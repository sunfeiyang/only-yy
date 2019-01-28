package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Genres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 影视类别数据库操作对象
 */
public interface Movie_Genres_Repository extends JpaRepository<Movie_Genres,Integer> {

    //根据subject_id过滤
    public ArrayList findBySubjectid(String subjectid);

    //根据subject_id进行过滤
    public ArrayList findBySubjectidAndGenresval(String subjectid,String genresval);
}
