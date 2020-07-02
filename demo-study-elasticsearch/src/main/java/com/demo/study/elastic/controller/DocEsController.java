package com.demo.study.elastic.controller;

import com.demo.domain.es.DocEs;
import com.demo.study.elastic.service.DocEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: Aaron Ma
 **/
@RestController
@RequestMapping("es")
public class DocEsController {

    @Autowired
    DocEsService docEsService;

    @GetMapping("/init")
    public void init() {
        this.docEsService.createIndex();
        List<DocEs> list = new ArrayList<DocEs>() {
            {
                add(new DocEs(1L, "XX0193", "XX8064", "xxxxxx", 1));
                add(new DocEs(2L, "XX0210", "XX7475", "xxxxxxxxx", 1));
                add(new DocEs(3L, "XXX0257", "XX8097", "xxxxxxxxxxxx", 1));
            }
        };
        this.docEsService.saveAll(list);
    }

    @GetMapping("/all")
    public Iterator<DocEs> findAll() {
        return this.docEsService.findAll();
    }
}
