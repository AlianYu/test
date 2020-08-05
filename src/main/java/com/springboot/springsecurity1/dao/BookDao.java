package com.springboot.springsecurity1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.springsecurity1.bean.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface BookDao extends BaseMapper<Book> {


}
