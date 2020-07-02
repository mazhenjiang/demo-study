package com.demo.domain.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @description: elasticsearch实体类
 * @author: Aaron Ma
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(indexName = "ems",type="_doc",shards = 1,replicas = 0)
public class DocEs {

    @Id
    private Long id;
    @Field(type = FieldType.Keyword)
    private String firstCode;
    @Field(type = FieldType.Keyword)
    private String secondCode;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String content;
    @Field(type = FieldType.Integer)
    private Integer type;


}
