package com.demo.study.elastic.dao;

import com.demo.domain.es.DocEs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DocEsRepository extends ElasticsearchRepository<DocEs, Long> {

    Page<DocEs> findByContent(String content, Pageable pageable);

    @Query("{\"bool\":{\"must\": {\"field\": {\"firstCode.keyword\": \"?\"}}}}")
    Page<DocEs> findByFirstCode(String firstCode, Pageable pageable);

    @Query("{\"bool\": {\"must\": {\"field\":{\"secondCode.keyword\":\"?\"}}}}")
    Page<DocEs> findByScondCode(String secondCode, Pageable pageable);
}
