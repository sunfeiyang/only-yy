package com.sunfy.yy.common.service.impl;

import com.sunfy.yy.common.repository.Common_Carousel_Repository;
import com.sunfy.yy.common.service.Common_Carousel_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Common_Carousel_ServiceImpl implements Common_Carousel_Service {

    @Autowired
    private Common_Carousel_Repository common_carousel_repository;

    @Override
    public ArrayList getCommon_Carousel() {

        ArrayList result = (ArrayList) common_carousel_repository.findAll();
        return result;
    }
}
