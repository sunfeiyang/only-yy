package com.sunfy.yy.common.utils;

import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.enums.EnumCultureException;

/**
 * 工具类  处理返回信息
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(EnumCultureException.SUCCESS.getCode());
        result.setMsg(EnumCultureException.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static Result error(EnumCultureException enumCultureException){
        Result result = new Result();
        result.setCode(enumCultureException.getCode());
        result.setMsg(enumCultureException.getMsg());
        result.setData(null);
        return result;
    }

}
