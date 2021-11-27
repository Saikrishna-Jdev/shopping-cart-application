package com.sca.webapp.service;

import com.sca.webapp.entity.Book;
import com.sca.webapp.entity.Product;
import com.sca.webapp.entity.ProductCategory;
import com.sca.webapp.exception.BookNotFoundException;
import com.sca.webapp.exception.EmptyInputFieldException;
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

    Book book;

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
        book=repository.getById(id);
        if(book !=null)
            return book;
        else
            throw new BookNotFoundException("Sorry The Book which you are looking is not Available.");
    }

    @Override
    public Book saveBook(Book book) {
        log.info("The Book is saved : {}",book);
        if(book.getAuthor().isEmpty()||book.getGenere().isEmpty())
            throw new EmptyInputFieldException("Mandatory Fields are Empty.");
        Book savedBook= repository.save(book);
        return savedBook;
    }

   /* @Override
    public List<Book> getProductsByCategory(String productCategory) {
        return repository.displayProductsByCategory(productCategory);
    }*/
}
