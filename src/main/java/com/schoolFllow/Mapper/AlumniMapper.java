package com.schoolFllow.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.schoolFllow.Domain.Entity.Activity;
import com.schoolFllow.Domain.Entity.Alumni;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AlumniMapper extends BaseMapper<Alumni> {
        Alumni selectByNameAndPassword (@Param("Name") String Name, @Param("password") String   password );
        List<Alumni> selectAll();
        //根据发起者查询活动
        List<Activity> queryAcByAlumniMain( @Param("masterId") int alu_id);
        //查询校友参加了什么活动
        List<Activity> queryActivity(@Param("aluId") int alu_id);

        //根据名字，电话查询用户
        List<Alumni> searchByNameAndPhone( @Param("Name") String Name,@Param("phone") String phone);

        //根据名字，查id
        List<Integer> searchIdByName(@Param("Name") String Name);

}
