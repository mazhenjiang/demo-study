package com.demo.study.elastic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Aaron Ma
 **/
@RestController
@RequestMapping("elastic_search")
public class ElasticController {

    @RequestMapping("/hi")
    public String hiElasticSerach() {
        return "hi elastic!";
    }
}
