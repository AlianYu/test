package com.sunline.clhd.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunline.clhd.example.entity.Hello;
import org.springframework.stereotype.Repository;


@Repository
public interface HelloMapper extends BaseMapper<Hello> {

}
