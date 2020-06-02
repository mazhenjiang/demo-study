package com.demo.study.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Aaron Ma
 **/

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@RestController
public class DemoCacheApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoCacheApplication.class);
    }


    @GetMapping("hi")
    public String hi() {

        return "demo study cache";
    }
}
