package com.sunfy.yy;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 * 使用项目用服务器启动
 */
public class SpringBootStartYYApplication extends SpringBootServletInitializer {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(YyApplication.class);
    }
}
