package com.sunfy.yy.AipOcr.service;

import java.util.ArrayList;

/**
 * OCR
 */
public interface OcrService {

    /**
     * 通用文字识别
     * @param ImageUrl 待识别的图片地址
     * @return String 识别返回信息
     */
    public ArrayList OcrText(String ImageUrl);

}
