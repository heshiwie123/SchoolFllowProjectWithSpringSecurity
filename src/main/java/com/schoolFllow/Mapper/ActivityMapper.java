package com.schoolFllow.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.schoolFllow.Domain.Entity.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {
    //查询所有活动列表
    List<Activity> selectAll();
    //模糊查询，%name%
    List<Activity> selectByName(@Param("name") String name);

    //searchByTitleAndUsername
    List<Activity> searchByTitleAndId(@Param("acTitle") String title,@Param("aluid") Integer aluid);

}
