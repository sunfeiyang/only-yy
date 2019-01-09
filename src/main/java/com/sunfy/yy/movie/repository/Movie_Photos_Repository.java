package com.sunfy.yy.movie.repository;

import com.sunfy.yy.movie.domain.Movie_Photos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * 剧照数据库操作对象
 */
public interface Movie_Photos_Repository extends JpaRepository<Movie_Photos,Integer> {

    //根据subject_id进行过滤
    public ArrayList findBySubjectid(String subjectid);

    //Photosid
    public ArrayList findByPhotosid(String photosid);

    //Photosid&subject_id
    public ArrayList findByPhotosidAndSubjectid(String photosid,String subjectid);
}
