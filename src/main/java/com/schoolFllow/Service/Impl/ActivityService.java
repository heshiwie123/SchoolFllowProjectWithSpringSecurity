package com.schoolFllow.Service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.schoolFllow.Domain.Entity.Activity;
import com.schoolFllow.Mapper.ActivityMapper;
import com.schoolFllow.Mapper.AlumniMapper;
import com.schoolFllow.Service.IActivityService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ActivityService extends ServiceImpl<ActivityMapper,Activity> implements IActivityService {
    @Resource
    ActivityMapper activityMapper;
    @Resource
    AlumniMapper alumniMapper;

    public List<Activity> selectAll(){
        return activityMapper.selectAll();
    }

    public List<Activity> selectBtyName(String name){
        return activityMapper.selectByName(name);
    }

    public Integer insertOne(Activity activity){
         return 0;
    }

    public List<Activity> searchByTitleAndUsername(  String title, String username){
        List<Integer> aluidList=alumniMapper.searchIdByName(username);
        System.out.println(aluidList);
        List<Activity> activityList1 = new ArrayList<Activity>();

        for (int aluid : aluidList) {
            List<Activity> activityList2 = new ArrayList<Activity>();
            activityList2=activityMapper.searchByTitleAndId(title,aluid);
            activityList1.addAll(activityList2);
        }
        System.out.println(activityList1);
        return activityList1;
    }
}
