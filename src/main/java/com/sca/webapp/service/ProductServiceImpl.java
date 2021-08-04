package com.sca.webapp.service;

import com.sca.webapp.entity.Product;
import com.sca.webapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getProductById(int productId){
        return productRepository.getById(productId);
    }

    @Override
    public Product getProductByName(String productName) {

        return productRepository.getProductByProductName(productName);
    }

    @Override
    public Product getProductByCategory(String productCategory) {
        return productRepository.getProductByProductCategory(productCategory);
    }
}
