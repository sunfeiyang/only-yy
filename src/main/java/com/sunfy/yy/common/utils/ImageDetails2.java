package com.sunfy.yy.common.utils;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;

/**
 * 测试用于读取图片的EXIF信息
 *
 * @author Winter Lau
 */
public class ImageDetails2 {
    public void test(){

    }

    public static void main(String[] args) throws Exception {
        File jpegFile = new File("E:/空气净化器.jpg");
        Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
        for(Directory directory : metadata.getDirectories()){
            for(Tag tag : directory.getTags()){
                System.out.print("name : " + tag.getTagName() + "  -->");
                System.out.println("desc : " + tag.getDescription());
            }
        }
    }
}