package com.springboot.springsecurity1.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.Api;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;
import java.util.Date;

@Data
@Api("Book实体类")
public class Book implements Serializable {
    @Excel(name="编号")
    private int bookId;
    @Excel(name="书名")
    private String bookName;
    @Excel(name="封面图")
    private String picture;
    @Excel(name="拥有者")
    private int ownerId;
    @Excel(name="当前借书者")
    private int currentOwnerId;
    @Excel(name="作者")
    private String author;
    @Excel(name="描述")
    private String description;
    @Excel(name="登记时间")
    private Date createdTime;
    @Excel(name="最近修改时间")
    private Date  updateTime;

    public Book() {
    }

    public Book(String bookName, String picture, int ownerId, int currentOwnerId, String author, String description) {
        this.bookName = bookName;
        this.picture = picture;
        this.ownerId = ownerId;
        this.currentOwnerId = currentOwnerId;
        this.author = author;
        this.description = description;
    }
}