package com.sunline.clhd.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: lihu
 * @Date: 2020/7/17 017 14:16
 */
@Data
public class Hello {
    @TableId
    private Long id;
    @NotBlank(message = "名称不能为空")
    private String name;
    private String remark;
}
