package com.springboot.springsecurity1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.springsecurity1.bean.Book;
import com.springboot.springsecurity1.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
@Api("书本控制层")
@RequestMapping("book")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 根据书编号查询书的信息
     * @return
     */
    @ApiOperation(value ="传入bookId查询对应Book")
    @GetMapping("/get")
    public Book Search(int bookId){
        Book book = bookService.getBookById(bookId);
        System.out.println(book);
        return book;
    }

    @ApiOperation(value ="传入书名进行模糊查询")
    @GetMapping("/gets")
    public List<Book> likeSearch(Book book){
        List<Book> list= bookService.getBooksByName(book);
        System.out.println(list.size());
        for(Book b : list){
            System.out.println(b);
        }
        return list;
    }

    @ApiOperation(value ="传入书名和介绍进行模糊查询")
    @GetMapping("getsf")
    public List<Book> getBookByFuzzy(Book book){
        List<Book> list = bookService.getBookByFuzzy(book);
        for(Book b : list){
            System.out.println(b);
        }
        return list;
    }

    @ApiOperation(value ="联表查询，返回BookOwnerVO")
    @GetMapping("getall")
    public List<Object> getAll(){
        return bookService.selectAll();
    }

    @ApiOperation(value ="通过书名查书")
    @GetMapping("getbookbyname")
    public List<Book> getBookByBookName(String bookName){
        return bookService.getBookByBookName(bookName);
    }

    @ApiOperation(value ="添加一本书")
    @PostMapping ("add")
    public int getBookByBookName(Book book){
        return bookService.addBook(book);
    }

    @ApiOperation(value ="删除一本书")
    @PostMapping("delete")
    public int getBookByBookName(int bookid){
        return bookService.deleteBook(bookid);
    }

    @ApiOperation(value ="修改一本书的信息")
    @PostMapping("update")
    public int update(Book book){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("book_id",book.getBookId());
        return bookService.updateBook(book,queryWrapper);
    }


}
