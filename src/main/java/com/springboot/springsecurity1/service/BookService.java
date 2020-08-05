package com.springboot.springsecurity1.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.springsecurity1.bean.Book;
import com.springboot.springsecurity1.dao.BookDao;

import java.util.List;
import java.util.Map;

public interface BookService{
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
}
