package com.schoolFllow.Controller;


import com.schoolFllow.Domain.Entity.Alumni;

import com.schoolFllow.Domain.Entity.Item;
import com.schoolFllow.Service.Impl.AlumniService;

import jakarta.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@PreAuthorize("hasAuthority('/alumni')")
@RequestMapping("/Alumni")
@CrossOrigin(origins = {"*"}) // 允许来自指定域的请求
public class AlumniController {
    @Resource
    AlumniService alumniService;
    //登录接口，成功返回用户信息
    @PostMapping("/Login")
    public Alumni Login(@RequestBody Item item)
    {
        String Name=item.getUsername();
        String password=item.getPassword();

        System.out.println(Name + " " + password);
        return alumniService.Login(Name,password);
    }
   //注册接口
    @PostMapping("/Register")
    public Boolean addAlumni( @RequestBody Alumni alumni){
        System.out.println(alumni);
        Boolean res=alumniService.addAlumni(alumni);
        return res;
    }
    //查询所有
    @GetMapping("/allAlumni")
    public List<Alumni> allAlumni(){
        return alumniService.allAlumni();
    }
    @PostMapping("/searchByNameAndPhone")
    public List<Alumni> searchByNameAndPhone(@RequestBody Map<String, Object> maps){
        String Name= (String) maps.get("username");
        String phone= (String) maps.get("phone");
        System.out.println(Name);
        System.out.println(phone);
        return alumniService.searchByNameAndPhone(Name,phone);
    }
    @PostMapping("/updateAlumni")
    public Boolean updateAlumniInfo( @RequestBody Alumni alumni){
        System.out.println("修改数据进入");
        System.out.println(alumni);
        return alumniService.saveOrUpdate(alumni);
    }
    @PostMapping("/deleteAlumni")
    public Boolean deleteAlumniInfo(@RequestBody Map<String, Object> maps){
        System.out.println(maps.get("id"));
        Integer Id = (Integer) maps.get("id");
        return alumniService.removeById(Id);
    }

}
