package com.sunfy.yy.common.enums;

public enum EnumCultureException {

    SUCCESS(1000,"数据请求成功！"),
    SUCCESSNULL(1001,"暂无相关数据！"),
    DB_INSERT(2000,"违反数据库唯一性约束！"),
    NETWORKANOMALY(3000,"网络异常！"),
    ERROR_NULL(4000,"请求数据为空！"),
    ERROR_UNKNOW(4444,"未知错误！");

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
