package com.sunfy.yy.common.utils;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;

public class ImageDetails {

    public static void main(String[] args) {

        //包含EXIF信息的图片地址
        File jpegFile = new File("E:/空气净化器.jpg");
        
        try{
            Metadata metadata = ImageMetadataReader.readMetadata(jpegFile);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    System.out.println(tag);
                }
            }
        }catch (Exception e){

        }
    }
}