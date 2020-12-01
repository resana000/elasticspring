package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Indexed;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@XmlRootElement
@Document(indexName = "dc_catalog", indexStoreType = "dc_catalog")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DcCatalog {
    @Id
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Date last_update;
    @Field(type = FieldType.Nested, value = "delivery_service", name = "delivery_service", index = true, store = true)
    private Delivery_service delivery_service;
}