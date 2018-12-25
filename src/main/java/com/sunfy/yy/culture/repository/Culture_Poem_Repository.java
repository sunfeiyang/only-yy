package com.sunfy.yy.culture.repository;

import com.sunfy.yy.culture.domain.Culture_Poem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 唐诗宋词的数据库操作对象
 */
public interface Culture_Poem_Repository extends JpaRepository<Culture_Poem,Integer> {
    //根据tid进行过滤
    public Culture_Poem findByTid(Integer tid);
    //根据标题、作者进行过滤(插入数据库时检查唯一性)
    public List<Culture_Poem> findByPoembiaotiAndPoemzuozhe(String poembiaoti,String poemzuozhe);
    //根据标题、内容以及作者进行过滤(搜索功能)
    public Culture_Poem findByPoembiaotiOrPoemzuozheOrPoemneirong(String poembiaoti,String poemzuozhe,String poemneirong);
    //根据poemID过滤
    public Culture_Poem findByPoemid(String poemid);

    public List findByPoembiaotiLike(String keyword);

    public List findByPoemzuozheLike(String keyword);
}
