package com.sunfy.yy.common.repository;

import com.sunfy.yy.common.domain.Common_Carousel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 轮播图数据库查询对象
 */
public interface Common_Carousel_Repository extends JpaRepository<Common_Carousel,Integer> {

    // 根据tid查询
    public Common_Carousel findByTid(Integer tid);
}
