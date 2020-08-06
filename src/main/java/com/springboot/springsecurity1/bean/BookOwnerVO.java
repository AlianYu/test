package com.springboot.springsecurity1.bean;

import io.swagger.annotations.Api;

import java.util.Date;

@Api("BookOwnerVO关联查询实体类")
public class BookOwnerVO {
    private int bookId;
    private String bookName;
    private Date createdTime;
    private int ownerId;
    private String ownerName;
    private String ownerEmail;
    private String ownerAddress;

    public BookOwnerVO() {
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    @Override
    public String toString() {
        return "BookOwnerVO{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", createdTime=" + createdTime +
                ", ownerId=" + ownerId +
                ", ownerName='" + ownerName + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                ", ownerAddress='" + ownerAddress + '\'' +
                '}';
    }
}
