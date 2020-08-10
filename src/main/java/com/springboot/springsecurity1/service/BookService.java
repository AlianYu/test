package com.springboot.springsecurity1.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.springsecurity1.bean.Book;
import com.springboot.springsecurity1.bean.BookOwnerVO;
import com.springboot.springsecurity1.dao.BookDao;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
//extends IService<Book>是为了批量插入
//BaseMapper未提供批量插入接口，但是在com.baomidou.mybatisplus.service.IService中提供了

@Api("书本服务层接口")
public interface BookService {
    int insertbBookBatch (List<Book> list);

    /**
     * 通过书本名字查找对应书籍
     * @param bookName
     * @return
     */
    List<Book> getBookByBookName(String bookName);
    /***
     * 根据书本编号查询书本信息
     * @param id  书本编号
     * @return
     */
    Book getBookById(int id);

    /**
     * 根据书名进行模糊查询书本信息
     * @param book 书本实体
     * @return
     */
    List<Book> getBooksByName(Book book);

    /**
     * 通过书本的名称或者描述进行模糊查询
     * @param book 书本实体
     * @return
     */
    List<Book> getBookByFuzzy(Book book);
    /**
     * 联表查询
     * @return
     */
    List<BookOwnerVO> selectAll();

    int addBook(Book book);
    int deleteBook(int bookId);
    int updateBook(Book book, Wrapper<Book> wrapper);

}
