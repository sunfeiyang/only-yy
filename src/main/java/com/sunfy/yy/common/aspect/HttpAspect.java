package com.sunfy.yy.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //加两个点表示所有参数都会拦截
    @Pointcut("execution(public * com.sunfy.yy.culture.controller.Culture_Today_History_Controller.*(..))")
//    @Before("execution(public * com.sunfy.yy.culture.controller.*(..))")
    public void log(){
    }

    //加两个点表示所有参数都会拦截
    @Before("log()")
//    @Before("execution(public * com.sfy.girl.controller.GirlController.*(..))")
    public void doBefore(JoinPoint joinPoint){
        logger.info("doBefore拦截成功！");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        logger.info("url2={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    //加两个点表示所有参数都会拦截
    @After("log()")
//    @After("execution(public * com.sfy.girl.controller.GirlController.*(..))")
    public void doAfter(){
        logger.info("doAfter拦截成功！");
    }

    //获取返回的内容
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
