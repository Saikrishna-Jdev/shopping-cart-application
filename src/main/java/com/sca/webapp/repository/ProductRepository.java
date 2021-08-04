package com.sca.webapp.repository;

import com.sca.webapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;

@Repository

public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product getProductByProductName(String ProductName);


    Product getProductByProductCategory(String productCategory);
}
