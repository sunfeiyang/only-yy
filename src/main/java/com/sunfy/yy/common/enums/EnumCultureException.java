package com.sunfy.yy.common.enums;

public enum EnumCultureException {

    SUCCESS(0000,"数据请求成功！"),
    ERROR(4001,"数据请求失败！"),
    ERROR_UNKNOW(4444,"未知错误！"),
    ERROR_NULL(4000,"请求数据为空！");

    private Integer code;

    private String msg;

    EnumCultureException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
