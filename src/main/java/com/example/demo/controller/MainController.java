package com.example.demo.controller;

import com.example.demo.model.DcCatalog;
import com.example.demo.service.MainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MainController {

    @Autowired
    MainService mainService;

    @PostMapping(value = "/root", consumes = MediaType.TEXT_XML_VALUE)
    public void ok(@RequestBody DcCatalog r) throws JsonProcessingException {
        mainService.save(r);
    }

    @GetMapping("/delete/all")
    public void deleteAll(){
        mainService.deleteAll();
    }

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity w(){
        return ResponseEntity.ok(mainService.allProduct());
    }

    @GetMapping(value = "/search/root/{word}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity search(@PathVariable String word){
        return ResponseEntity.ok(mainService.findRoot(word));
    }

    @GetMapping(value = "/search/{word}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchProduct(@PathVariable String word){
        return ResponseEntity.ok(mainService.findRootProduct(word));
    }
}
