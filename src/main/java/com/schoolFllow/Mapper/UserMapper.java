package com.schoolFllow.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.schoolFllow.Domain.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User getByNameAndPassword(@Param("name")String name,@Param("password")String password);
    User selectUserByUsername(@Param("name")String name);
}
