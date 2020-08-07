package com.springboot.springsecurity1.bean;

import io.swagger.annotations.Api;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;
import java.util.Date;

@Data
@Api("Book实体类")
public class Book implements Serializable {
    private int bookId;
    private String bookName;
    private String picture;
    private int ownerId;
    private int currentOwnerId;
    private String author;
    private String description;
    private Date createdTime;
    private Date  updateTime;

}