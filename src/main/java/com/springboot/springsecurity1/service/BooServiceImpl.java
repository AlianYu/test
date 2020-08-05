package com.springboot.springsecurity1.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.springsecurity1.bean.Book;
import com.springboot.springsecurity1.dao.BookDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BooServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getBookByFuzzy(Book book) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(book.getBookName()),"book_name",book.getBookName())
                .or().like(!StringUtils.isEmpty(book.getDescription()),"description",book.getDescription());
        return bookDao.selectList(queryWrapper);
    }

    @Override
    public List<Book> getBooksByName(Book book) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(true, "book_name", book.getBookName());
        System.out.println(book.getBookName()+"--------------------------------");
        List<Book> list = bookDao.selectList(queryWrapper);
        return list;
    }

    @Override
    public Book getBookById(int id) {
        QueryWrapper<Book> wrapper = new QueryWrapper<Book>();
        wrapper.eq("book_id",id);
        return bookDao.selectOne(wrapper);

    }
}
