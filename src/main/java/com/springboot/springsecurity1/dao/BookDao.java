package com.springboot.springsecurity1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.springsecurity1.bean.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@ApiOperation(value ="Book的dao层")
@Component
public interface BookDao extends BaseMapper<Book> {
    /**
     * 联表查询
     * @return
     */
    List<Object> selectAll();


}
