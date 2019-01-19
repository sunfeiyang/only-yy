package com.sunfy.yy.common.enums;

/**
 * 关于路径的相关常量
 */
public enum EnumPath {

    BASHPATH("E:\\apache\\apache-tomcat\\tomcat-xsy-8.5.4\\webapps\\");

    private String value;

    EnumPath(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
