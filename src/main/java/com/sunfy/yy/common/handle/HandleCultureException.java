package com.sunfy.yy.common.handle;

import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.enums.EnumCultureException;
import com.sunfy.yy.common.exception.ExceptionCulture;
import com.sunfy.yy.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 异常捕获
 */
@ControllerAdvice
public class HandleCultureException {

    private static final Logger logger = LoggerFactory.getLogger(HandleCultureException.class);

    public Result Handle(Exception e){
        if(e instanceof ExceptionCulture){
            ExceptionCulture exceptionCulture = (ExceptionCulture) e;
            return ResultUtil.error(exceptionCulture.getCode(), exceptionCulture.getMessage());
        }else {
            logger.info("【系统异常】{}",e);
            return ResultUtil.error(EnumCultureException.ERROR_UNKNOW);
        }
    }
}
