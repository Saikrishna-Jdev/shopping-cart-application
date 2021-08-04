package com.sca.webapp.service;

import com.sca.webapp.entity.Book;
import com.sca.webapp.entity.Product;
import com.sca.webapp.entity.ProductCategory;
import com.sca.webapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl  implements BookService{

    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book getBookbyId(int id) {
        return repository.getById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

   /* @Override
    public List<Book> getProductsByCategory(String productCategory) {
        return repository.displayProductsByCategory(productCategory);
    }*/
}
