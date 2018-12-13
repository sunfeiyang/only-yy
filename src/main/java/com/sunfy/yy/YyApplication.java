package com.sunfy.yy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
/**
 * EnableScheduling 启用定时任务
 */
public class YyApplication {

    public static void main(String[] args) {
        SpringApplication.run(YyApplication.class, args);
    }
}
