package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "category", indexStoreType = "category")
public class Category {

    @Id
    private String id;
    private String content;
}
