package com.springboot.springsecurity1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.springsecurity1.bean.Book;
import com.springboot.springsecurity1.bean.Owner;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;

@ApiOperation(value ="Owner的dao层")
@Component
public interface OwnerDao extends BaseMapper<Owner> {
}
