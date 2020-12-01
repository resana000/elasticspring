package com.example.demo.elastic.repo;

import com.example.demo.model.DcCatalog;
import com.example.demo.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product,String> {

}
