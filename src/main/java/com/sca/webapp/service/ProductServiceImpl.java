package com.sca.webapp.service;

import com.sca.webapp.entity.Product;
import com.sca.webapp.exception.ProductNotFoundException;
import com.sca.webapp.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getProductById(int productId){
        Product product= productRepository.getById(productId);
        if(product==null){
            throw new ProductNotFoundException("Sorry The Product you are looking is not available");
        }
        else{
            return product;
        }
    }

    @Override
    public Product getProductByName(String productName) {
        log.debug("Inside the getProductByName() in ProductServiceImpl");
        return productRepository.getProductByProductName(productName);
    }

    @Override
    public Product getProductByCategory(String productCategory) {
        return productRepository.getProductByProductCategory(productCategory);
    }
}
