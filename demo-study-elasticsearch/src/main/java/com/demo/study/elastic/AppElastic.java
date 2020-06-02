package com.demo.study.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @description: 启动类
 * @author: Aaron Ma
 **/
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class AppElastic {

    public static void main(String[] args) {
        SpringApplication.run(AppElastic.class);
    }
}
