package com.schoolFllow.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.schoolFllow.Domain.Entity.Function;
import com.schoolFllow.Mapper.FunctionMapper;
import com.schoolFllow.Service.FunctionService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class FunctionServiceImpl extends ServiceImpl<FunctionMapper,Function> implements FunctionService {
    @Resource
    FunctionMapper functionMapper;

    List<Function> getFunctionsByUserId(Integer userId){
        return  functionMapper.getFunctionsByUserId(userId);
    }
}
