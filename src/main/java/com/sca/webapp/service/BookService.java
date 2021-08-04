package com.sca.webapp.service;

import com.sca.webapp.entity.Book;
import com.sca.webapp.entity.Product;
import com.sca.webapp.entity.ProductCategory;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookbyId(int id);
    Book saveBook(Book book);
   // List<Book> getProductsByCategory(String productCategory);

}
