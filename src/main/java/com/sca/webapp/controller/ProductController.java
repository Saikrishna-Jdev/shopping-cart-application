package com.sca.webapp.controller;

import com.sca.webapp.entity.Product;
import com.sca.webapp.entity.ProductCategory;
import com.sca.webapp.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl service;

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return service.getAll();

    }

    @GetMapping("/getProductById/{productId}")
    public Product getProductById(@PathVariable("productId") int productId){
        return service.getProductById(productId);
    }

    @GetMapping("/getProductByName/{productName}")
    public Product getProductByName(@PathVariable("productName") String productName){
        return service.getProductByName(productName);

    }

    @GetMapping("/getProductByCategory/{productCategory}")
    public Product getProductByCategory(@PathVariable("category") String productCategory){
        System.out.println("productCategory is : "+productCategory);
        return service.getProductByCategory(productCategory);
    }

}
