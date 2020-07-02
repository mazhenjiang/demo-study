package com.demo.study.elastic.service.impl;

import com.demo.domain.es.DocEs;
import com.demo.study.elastic.dao.DocEsRepository;
import com.demo.study.elastic.service.DocEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: Aaron Ma
 **/
@Service("docEsService")
public class DocEsServiceImpl implements DocEsService {

    @Autowired
    private ElasticsearchRestTemplate esRestTemplate;
    @Autowired
    private DocEsRepository docEsRepository;

    private Pageable pageable= PageRequest.of(0,10);

    @Override
    public void createIndex() {
        this.esRestTemplate.createIndex(DocEs.class);
    }

    @Override
    public void deleteIndex(String index) {
        this.esRestTemplate.deleteIndex(index);
    }

    @Override
    public void save(DocEs docEs) {
        this.docEsRepository.save(docEs);
    }

    @Override
    public void saveAll(List<DocEs> list) {
        this.docEsRepository.saveAll(list);
    }

    @Override
    public Iterator<DocEs> findAll() {
        return this.docEsRepository.findAll().iterator();
    }

    @Override
    public Page<DocEs> findByContent(String content) {
        return this.docEsRepository.findByContent(content,this.pageable);
    }

    @Override
    public Page<DocEs> findByFirstCode(String firstCode) {
        return this.docEsRepository.findByContent(firstCode,this.pageable);
    }

    @Override
    public Page<DocEs> findBySecondCode(String secondCode) {
        return this.docEsRepository.findByScondCode(secondCode,this.pageable);
    }

    @Override
    public Page<DocEs> query(String key) {
        return this.docEsRepository.findByContent(key,this.pageable);
    }
}
