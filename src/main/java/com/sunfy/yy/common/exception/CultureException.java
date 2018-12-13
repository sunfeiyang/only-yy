package com.sunfy.yy.common.exception;

/**
 * 异常类
 * 注意：在继承父类时要继承RuntimeException（RuntimeException继承于Exception，发生异常时会回滚，直接继承Exception，则发生异常时不回滚）
 */
public class CultureException extends RuntimeException{

}
