package com.schoolFllow.Domain.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;

@Data
@TableName("activity")
public class Activity {
    //活动id
    @TableId(value = "ac_id", type = IdType.AUTO)
    private Integer acId;
    //活动标题
    private String acTitle;
    // 活动描述
    private String acDesc;
    // 活动发起人
    private Integer aluId;
    // 活动创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime acCreateTime;
    // 活动开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime acStartTime;
    // 活动结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime acEndTime;
    // 需要人数
    private Integer acCount;
    // 审核状态：0未审核，1通过，2未通过
    private Integer acStatus;
    // 审核意见
    private String acOpinion;


}
