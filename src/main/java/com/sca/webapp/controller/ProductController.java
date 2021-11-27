package com.sca.webapp.controller;

import com.sca.webapp.entity.Product;
import com.sca.webapp.entity.ProductCategory;
import com.sca.webapp.exception.ProductNotFoundException;
import com.sca.webapp.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@Slf4j
public class ProductController {
    @Autowired
    private ProductServiceImpl service;


    @GetMapping("/")
    public List<Product> getAllProducts(){
        log.info("Printing All The Products {}",service.getAll());
        return service.getAll();

    }

    @GetMapping("/getProductById/{productId}")
    public Product getProductById(@PathVariable("productId") int productId){
        log.debug("Request for Product with an ID: {} ",+productId);
        //log.error("Product is not found with an ID: {}",+productId);
         return service.getProductById(productId);
    }

    @GetMapping("/getProductByName/{productName}")
    public Product getProductByName(@PathVariable("productName") String productName){
        log.debug("Getting the Product By Name : {}",productName);
        return service.getProductByName(productName);

    }

    @GetMapping("/getProductByCategory/{productCategory}")
    public Product getProductByCategory(@PathVariable("category") String productCategory){
        log.debug("productCategory is : {} ",productCategory);
        return service.getProductByCategory(productCategory);
    }

}
