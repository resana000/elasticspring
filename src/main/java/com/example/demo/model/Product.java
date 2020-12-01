package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "product")
public class Product {
    private String category_id;

    private String price;

    private String name;

    private String description;

    @Id
    private String id;

    private String picture;
}
