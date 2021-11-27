package com.sca.webapp.controller;

import com.sca.webapp.entity.Book;
import com.sca.webapp.entity.Product;
import com.sca.webapp.entity.ProductCategory;
import com.sca.webapp.exception.BookNotFoundException;
import com.sca.webapp.exception.EmptyInputFieldException;
import com.sca.webapp.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/all")
    public List<Book> getAllBooks(){
        log.info("Getting the List of Books {} "+bookService.getAllBooks());
        return bookService.getAllBooks();

    }

    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable("id") int id){

        log.debug("Request for th eBook with an Id: {} ",id);
        return bookService.getBookbyId(id);
    }

    @PostMapping("/save")

    public Book saveBook(@RequestBody Book book){


        log.debug(" Saving The Book Written By : {} ",book.getAuthor());

        return bookService.saveBook(book);
    }


   /* @GetMapping("/find/category/{productCategory}")
    public List<Book> getProductsByCategory(@PathVariable("productCategory") String productCategory){
        return bookService.getProductsByCategory(productCategory);
    }*/




}
