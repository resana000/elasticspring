package com.example.demo.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@Document(indexName = "delivery_service")
public class Delivery_service {
    private List<Category> categories;
    private List<Product> products;
}