package com.sca.webapp.controller;

import com.sca.webapp.entity.Book;
import com.sca.webapp.entity.Product;
import com.sca.webapp.entity.ProductCategory;
import com.sca.webapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();

    }

    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable("id") int id){

        return bookService.getBookbyId(id);
    }

    @PostMapping("/save")
    public Book saveBook(@RequestBody Book book){
        System.out.println(book.getAuthor());

        return bookService.saveBook(book);
    }


   /* @GetMapping("/find/category/{productCategory}")
    public List<Book> getProductsByCategory(@PathVariable("productCategory") String productCategory){
        return bookService.getProductsByCategory(productCategory);
    }*/




}
