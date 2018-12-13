package com.sunfy.yy.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
/**
 * @Configuration：表明该类是一个配置类
 * @EnableAsync：开启异步事件的支持
 */
public class AsyncConfig {
     /*
    此处成员变量应该使用@Value从配置中读取
     */
    //最小连接数
    @Value("${AsyncConfig.corePoolSize}")
    private int corePoolSize;
    //最大连接数
    @Value("${AsyncConfig.maxPoolSize}")
    private int maxPoolSize;
    //等候线程容量
    @Value("${AsyncConfig.queueCapacity}")
    private int queueCapacity;

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        return executor;
    }
}