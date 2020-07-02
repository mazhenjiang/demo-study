package com.demo.study.elastic.service;

import com.demo.domain.es.DocEs;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

public interface DocEsService {

    void createIndex();

    void deleteIndex(String index);

    void save(DocEs docEs);

    void saveAll(List<DocEs> list);

    Iterator<DocEs> findAll();

    Page<DocEs> findByContent(String content);

    Page<DocEs> findByFirstCode(String firstCode);

    Page<DocEs> findBySecondCode(String secondCode);

    Page<DocEs> query(String key);
}
