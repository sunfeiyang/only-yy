package com.sunfy.yy.common.handle;

import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.enums.EnumException;
import com.sunfy.yy.common.exception.ExceptionSystem;
import com.sunfy.yy.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 异常捕获
 */
@ControllerAdvice
public class HandleSystemException {

    private static final Logger logger = LoggerFactory.getLogger(HandleSystemException.class);

    public Result Handle(Exception e){
        if(e instanceof ExceptionSystem){
            ExceptionSystem exceptionCulture = (ExceptionSystem) e;
            return ResultUtil.error(exceptionCulture.getCode(), exceptionCulture.getMessage());
        }else {
            logger.info("【系统异常】{}",e);
            return ResultUtil.error(EnumException.ERROR_UNKNOW);
        }
    }
}
