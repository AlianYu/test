package com.springboot.springsecurity1.controller;

import com.springboot.springsecurity1.bean.Book;
import com.springboot.springsecurity1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 根据书编号查询书的信息
     * @return
     */
    @RequestMapping("/showBooks")
    public Book Search(int bookId){
        Book book = bookService.getBookById(bookId);
        System.out.println(book);
        return book;

    }

    @RequestMapping("/s")
    public List<Book> likeSearch(Book book){
        List<Book> list= bookService.getBooksByName(book);
        System.out.println(list.size());
        for(Book b : list){
            System.out.println(b);
        }
        return list;
    }

    @RequestMapping("fuzzy")
    public List<Book> getBookByFuzzy(Book book){
        List<Book> list = bookService.getBookByFuzzy(book);
        for(Book b : list){
            System.out.println(b);
        }
        return list;

    }
}
