package com.example.demo.service;

import com.example.demo.elastic.repo.CategoryRepository;
import com.example.demo.elastic.repo.MainRepository;
import com.example.demo.elastic.repo.ProductRepository;
import com.example.demo.model.Category;
import com.example.demo.model.DcCatalog;
import com.example.demo.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

@Service
@Slf4j
public class MainService {

    @Autowired
    ElasticsearchOperations elasticsearchRestTemplate;

    @Autowired
    MainRepository main;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<DcCatalog> findRoot(String word){
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(multiMatchQuery(word))
                .build();
        SearchHits<DcCatalog> dcCatalogSearchHits = elasticsearchRestTemplate
                .search(searchQuery, DcCatalog.class);
        return dcCatalogSearchHits.get().map(a->a.getContent()).collect(Collectors.toList());
    }

    public List<Product> findRootProduct(String word){
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(multiMatchQuery(word))
                .build();
        SearchHits<Product> dcCatalogSearchHits = elasticsearchRestTemplate
                .search(searchQuery, Product.class);
        return dcCatalogSearchHits.get().map(a->a.getContent()).collect(Collectors.toList());
    }

    public List<Category> findRootCategory(String word){
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(multiMatchQuery(word))
                .build();
        SearchHits<Category> dcCatalogSearchHits = elasticsearchRestTemplate
                .search(searchQuery, Category.class);
        return dcCatalogSearchHits.get().map(a->a.getContent()).collect(Collectors.toList());
    }

    public void save(DcCatalog dcCatalog) {
        main.save(dcCatalog);
        productRepository.saveAll(dcCatalog.getDelivery_service().getProducts());
        categoryRepository.saveAll(dcCatalog.getDelivery_service().getCategories());
    }

    public void deleteAll() {
        main.deleteAll();
    }

    public Iterable<Product> allProduct() {
        return productRepository.findAll();
    }

    public Product getProduct(String id) {
        return productRepository.findById(id).orElseThrow(()-> {
            throw new RuntimeException("not found");
        });
    }

    public Category getCategory(String id) {
        return categoryRepository.findById(id).orElseThrow(()->{
            throw new RuntimeException("not found");
        });
    }

}
