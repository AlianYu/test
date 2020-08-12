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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getCurrentOwnerId() {
        return currentOwnerId;
    }

    public void setCurrentOwnerId(int currentOwnerId) {
        this.currentOwnerId = currentOwnerId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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