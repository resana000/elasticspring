package com.example.demo.elastic.repo;

import com.example.demo.model.DcCatalog;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;

@Repository
public interface MainRepository extends ElasticsearchRepository<DcCatalog, Date> {

}
