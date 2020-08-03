package com.sunline.clhd.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sunline.clhd.example.entity.Hello;
import com.sunline.clhd.example.service.IHelloService;
import com.sunline.jraf.util.JrafAssert;
import com.sunline.jraf.web.BaseController;
import com.sunline.jraf.web.ResponseResult;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @Author: lihu
 * @Date: 2020/7/17 017 14:10
 */
@RestController
@RequestMapping("hello")
public class HelloController extends BaseController {

    @Autowired
    private IHelloService helloService;

    @GetMapping("query/page")
    public ResponseResult queryPage(@RequestParam Map<String, Object> param) {
        String name = MapUtils.getString(param, "name");
        LambdaQueryWrapper<Hello> queryWrapper = Wrappers.lambdaQuery(Hello.class)
                .like(StringUtils.isNotEmpty(name), Hello::getName, name);
        IPage<Hello> page = helloService.page(getIPage(param), queryWrapper);
        return result(page);
    }

    @GetMapping("query/unique")
    public ResponseResult queryUnique(@RequestParam Map<String, Object> param) {
        Long id = MapUtils.getLong(param, "id");
        JrafAssert.isNull(id, "非法参数，id不能为空");
        Hello hello = helloService.getById(id);
        return result(hello);
    }

    @PostMapping("add")
    public ResponseResult add(@RequestBody @Valid Hello hello) {
        helloService.save(hello);
        return result();
    }

    @PostMapping("update")
    public ResponseResult update(@RequestBody @Valid Hello hello) {
        helloService.saveOrUpdate(hello);
        return result();
    }

    @PostMapping("del")
    public ResponseResult del(@RequestBody Hello hello) {
        helloService.removeById(hello.getId());
        return result();
    }
}
