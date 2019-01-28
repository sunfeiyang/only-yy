package com.sunfy.yy.common.utils;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于读取图片的EXIF信息
 *
 * @author sunfy
 */
public class UtilsImageDetails {

    /**
     * 获取Image的EXIF信息然后返回
     * @param url 需要获得详情的图片链接
     * @return Map
     */
    public static Map getImageDetails(String url){
        File jpegFile = new File(url);
        Metadata metadata = null;
        // 数据查询后的返回结果集
        Map map = new HashMap();
        try {
            metadata = JpegMetadataReader.readMetadata(jpegFile);
            for(Directory directory : metadata.getDirectories()){
                for(Tag tag : directory.getTags()){
//                    System.out.print("name : " + tag.getTagName() + "  -->");
//                    System.out.println("desc : " + tag.getDescription());
                    map.put(tag.getTagName(),tag.getDescription());
                }
            }
            return map;
        } catch (JpegProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}