package com.schoolFllow.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.schoolFllow.Domain.Entity.Alumni;
import com.schoolFllow.Mapper.AlumniMapper;

import com.schoolFllow.Service.IAlumniService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

//extends ServiceImpl<AlumniMapper,Alumni>
@Service
public class AlumniService extends ServiceImpl<AlumniMapper,Alumni> implements IAlumniService {

    @Resource//自动注入
    private AlumniMapper alumniMapper;

    public Alumni Login(String Name,String password){

        return alumniMapper.selectByNameAndPassword(Name,password);
    }
    public Boolean addAlumni( Alumni alumni){
        int res=alumniMapper.insert(alumni);
        return res != 0;
    }
    public List<Alumni> allAlumni(){
        return alumniMapper.selectAll();
    }
    public List<Alumni> searchByNameAndPhone( String Name,String phone){
        return alumniMapper.searchByNameAndPhone( Name, phone);
    }

}
