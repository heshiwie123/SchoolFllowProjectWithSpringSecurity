package com.schoolFllow.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.schoolFllow.Domain.Entity.Function;
import com.schoolFllow.Domain.Entity.Identity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface IdentityMapper extends BaseMapper<Identity> {
    Set<Function> selectFunctionByIdentityIdS(@Param("Ids") Set<Integer> setId);
}
