package com.example.demo.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@Document(indexName = "delivery_service")
public class Delivery_service {
    @Field(type = FieldType.Object, value = "categories", name = "categories", index = true, store = true)
    private List<Category> categories;
    @Field(type = FieldType.Object, value = "products", name = "products", index = true, store = true)
    private List<Product> products;
}