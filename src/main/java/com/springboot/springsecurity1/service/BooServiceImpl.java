package com.springboot.springsecurity1.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.springsecurity1.bean.Book;
import com.springboot.springsecurity1.bean.BookOwnerVO;
import com.springboot.springsecurity1.dao.BookDao;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Api("书本服务层接口的实现类")
@Service
public  class BooServiceImpl implements BookService {


    @Autowired
    private BookDao bookDao;

    @Override
    public int insertbBookBatch(List<Book> list) {

        return bookDao.insertbBookBatch(list);
    }
    @Override
    public int addBook(Book book) {

        return bookDao.insert(book);
    }

    @Override
    public int updateBook(Book book,Wrapper<Book> wrapper) {
        return bookDao.update(book,wrapper);
    }



    @Override
    public int deleteBook(int bookId) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(bookId !=0 ? true : false,"Book_id",bookId);
        return bookDao.delete(queryWrapper);
    }

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
        List<Book> list = bookDao.selectList(queryWrapper);
        return list;
    }

    @Override
    public List<BookOwnerVO> selectAll() {
        return bookDao.selectAll();
    }

    @Override
    public Book getBookById(int id) {
        QueryWrapper<Book> wrapper = new QueryWrapper<Book>();
        wrapper.eq("book_id",id);

        return bookDao.selectOne(wrapper);

    }
    @Override
    public List<Book> getBookByBookName(String bookName) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Book::getBookName,bookName);
        return bookDao.selectList(queryWrapper);

    }














}
