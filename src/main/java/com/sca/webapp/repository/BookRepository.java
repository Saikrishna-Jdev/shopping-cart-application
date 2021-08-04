package com.sca.webapp.repository;

import com.sca.webapp.entity.Book;
import com.sca.webapp.entity.Product;
import com.sca.webapp.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

   // List<Book> displayProductsByCategory(String productCategory);
}
