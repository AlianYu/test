package com.springboot.springsecurity1.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import lombok.Data;

import java.util.List;

@Api("Owner用户实体类")
@TableName("t_bookowner")
@Data
public class Owner {
    @TableId
    private int ownerId;  //所属人编码
    private String ownerName;  //所属人姓名
    private String ownerSex;   //所属人性别
    private int ownerAge;    //所属人年龄
    private String ownerAddress;  //所属人地址
    private String ownerEmail;   //所属人邮箱
    private List<Book> bookList;

    public Owner() {
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

    public String getOwnerSex() {
        return ownerSex;
    }

    public void setOwnerSex(String ownerSex) {
        this.ownerSex = ownerSex;
    }

    public int getOwnerAge() {
        return ownerAge;
    }

    public void setOwnerAge(int ownerAge) {
        this.ownerAge = ownerAge;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
