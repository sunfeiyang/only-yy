package com.sunfy.yy.service;

import com.sunfy.yy.domain.Culture_Famous;
import com.sunfy.yy.domain.Result;

/**
 * 名人名言接口
 */
public interface Culture_Famous_Service {

    /**
     * 新增名人名言接口
     * @param url  请求链接地址
     * @return  Result对象
     */
    public Result<Culture_Famous> addFamous(String url);


}
