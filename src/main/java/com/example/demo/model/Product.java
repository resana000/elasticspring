package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.JoinTypeRelation;
import org.springframework.data.elasticsearch.annotations.JoinTypeRelations;
import org.springframework.data.elasticsearch.annotations.Mapping;

@Data
@Document(indexName = "product", indexStoreType = "product")
public class Product {

    private String category_id;

    private String price;

    private String name;

    private String description;

    @Id
    private String id;

    private String picture;
}
