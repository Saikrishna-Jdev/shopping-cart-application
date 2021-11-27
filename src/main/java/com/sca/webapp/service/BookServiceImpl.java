package com.sca.webapp.service;

import com.sca.webapp.entity.Book;
import com.sca.webapp.entity.Product;
import com.sca.webapp.entity.ProductCategory;
import com.sca.webapp.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class BookServiceImpl  implements BookService{

    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> getAllBooks() {
        log.info("List Of AllBooks : {} ",repository.findAll());
        return repository.findAll();
    }

    @Override
    public Book getBookbyId(int id) {
        log.debug("Request for Getting the Book with an ID: {} ",id);
        return repository.getById(id);
    }

    @Override
    public Book saveBook(Book book) {
        log.info("The Book is saved : {}",book);
        return repository.save(book);
    }

   /* @Override
    public List<Book> getProductsByCategory(String productCategory) {
        return repository.displayProductsByCategory(productCategory);
    }*/
}
