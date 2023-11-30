package com.schoolFllow.Controller;


import com.schoolFllow.Domain.Entity.Activity;

import com.schoolFllow.Service.Impl.ActivityService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@PreAuthorize("hasAuthority('/activity')")
@CrossOrigin(origins = {"*"}) // 允许来自指定域的请求
public class ActivityController {
    @Resource
    ActivityService activityService;

    @PreAuthorize("hasAuthority('/activity/search')")
    @GetMapping("/allActivity")
    public List<Activity> queryAll(){
        return activityService.selectAll();
    }


    @PreAuthorize("hasAuthority('/activity/search')")
    @PostMapping("/searchActivity")
    public List<Activity> queryByName(String name){
        System.out.println(name);
        return activityService.selectBtyName(name);
    }


    //根据标题和校友名字查询活动列表
    @PostMapping("/searchByTitleAndUsername")
    public List<Activity> searchByTitleAndUsername( @RequestBody Map<String,Object> maps){
        String title = (String) maps.get("acTitle");
        String username= (String) maps.get("username");
        System.out.println(title);
        System.out.println(username);
        return activityService.searchByTitleAndUsername(title,username);
    }

    @PostMapping("/deleteActivity")
    public Boolean deleteAlumniInfo(@RequestBody Map<String, Object> maps){
        System.out.println(maps.get("id"));
        Integer Id = (Integer) maps.get("id");
        return activityService.removeById(Id);
    }
    @PostMapping("/updateActivity")
    public Boolean updateAlumniInfo( @RequestBody Activity activity){
        System.out.println("修改数据进入");
        System.out.println(activity);
        return activityService.saveOrUpdate(activity);
    }

}
