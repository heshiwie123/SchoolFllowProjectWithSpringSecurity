package com.schoolFllow.Domain.Entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "Alumni")//指定表名
public class Alumni {
    //校友Id
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    //名字
    private String name;
    //密码
    private String password;
    //性别
    private String sex;
    //籍贯
    private  String nativePlace;
    //入学年份
    private String enrollmentYear;
    //毕业年份
    private String graduatedYear;
    //毕业系别
    private String graduatedDepartment;
    //政治面貌
    private  String politicsStatus;
    //地址
    private String address;
    //号码
    private String mobile;

}
