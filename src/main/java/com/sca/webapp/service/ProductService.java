package com.sca.webapp.service;

import com.sca.webapp.entity.Product;


import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getProductById(int productId);
    Product getProductByName(String productName);
    Product getProductByCategory(String category);
}
