package com.sunfy.yy.AipOcr.controller;

import com.sunfy.yy.AipOcr.service.OcrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * 文字识别控制类
 */
@RestController
public class OcrController {

    private final static Logger logger = LoggerFactory.getLogger(OcrController.class);

    @Autowired
    private OcrService ocrService;

    @GetMapping(value = "OcrUpload/{imageUrl}")
    public ArrayList OcrText(@PathVariable("imageUrl") String imageUrl){
        if(logger.isInfoEnabled()){
            logger.info("【OcrTextController—OcrText】请求成功！ 参数为：【"+imageUrl+"】");
        }
        return ocrService.OcrText(imageUrl);
    }
}
