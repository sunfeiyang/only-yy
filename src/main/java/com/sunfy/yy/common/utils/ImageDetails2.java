package com.sunfy.yy.common.utils;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;

public class ImageDetails2 {

    public static void main(String[] args) throws JpegProcessingException, IOException {

//        //包含EXIF信息的图片地址
//        File jpegFile = new File("E:/空气净化器.jpg");
//
//        try{
//            Metadata metadata = ImageMetadataReader.readMetadata(jpegFile);
//            for (Directory directory : metadata.getDirectories()) {
//                for (Tag tag : directory.getTags()) {
//                    System.out.println(tag);
//                }
//            }
//        }catch (Exception e){
//
//        }
//    }
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