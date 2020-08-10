package com.springboot.springsecurity1.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.Api;
import lombok.Data;

import java.util.Date;
@Data
@Api("BookOwnerVO关联查询实体类")
public class BookOwnerVO {
    @Excel(name="编号")
    private int bookId;
    @Excel(name="书名")
    private String bookName;
    @Excel(name = "创建时间")
    private Date createdTime;
    @Excel(name="拥有者编号")
    private int ownerId;
    @Excel(name = "拥有者名称")
    private String ownerName;
    @Excel(name = "邮箱")
    private String ownerEmail;
    @Excel(name="地址")
    private String ownerAddress;

}
