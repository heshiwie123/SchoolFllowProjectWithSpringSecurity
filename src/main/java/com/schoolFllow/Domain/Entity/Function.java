package com.schoolFllow.Domain.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName(value = "function")
public class Function implements Serializable {
    @TableId(value = "id")
    private Integer id;
    private String name;
    private String parentId;
    private String perms;
    private String menuType;
}
