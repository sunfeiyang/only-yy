package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Photos;
import com.sunfy.yy.movie.domain.Movie_Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 剧照数据库操作对象
 */
public interface Movie_Video_Repository extends JpaRepository<Movie_Video,Integer> {

    //根据subject_id进行过滤
    public ArrayList findBySubjectid(String subjectid);

    //Videoid
    public ArrayList findByVideoid(String videoid);

    //Videoid&subject_id
    public ArrayList findByVideoidAndSubjectid(String videoid, String subjectid);
}
