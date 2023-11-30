package com.schoolFllow.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.schoolFllow.Domain.Entity.Function;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface FunctionMapper extends BaseMapper<Function> {
    //根据用户id选择权限
    List<Function> getFunctionsByUserId(@Param("userId") Integer userId);
}
