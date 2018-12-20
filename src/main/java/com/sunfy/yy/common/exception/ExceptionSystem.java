package com.sunfy.yy.common.exception;

import com.sunfy.yy.common.enums.EnumException;

/**
 * 异常类
 * 注意：在继承父类时要继承RuntimeException（RuntimeException继承于Exception，发生异常时会回滚，直接继承Exception，则发生异常时不回滚）
 */
public class ExceptionSystem extends RuntimeException{

    private Integer code;

    public ExceptionSystem(EnumException enumCultureException){
        super(enumCultureException.getMsg());
        this.code = enumCultureException.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
