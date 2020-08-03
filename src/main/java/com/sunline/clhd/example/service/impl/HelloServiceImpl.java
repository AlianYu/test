package com.sunline.clhd.example.service.impl;

import com.sunline.clhd.example.entity.Hello;
import com.sunline.clhd.example.mapper.HelloMapper;
import com.sunline.clhd.example.service.IHelloService;
import com.sunline.jraf.web.BaseService;
import org.springframework.stereotype.Service;


@Service
public class HelloServiceImpl extends BaseService<HelloMapper, Hello>
        implements IHelloService {
}
