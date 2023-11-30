package com.schoolFllow.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.schoolFllow.Domain.Dto.LoginParams;
import com.schoolFllow.Domain.Entity.User;


public interface UserService extends IService<User> {
    public User getByNameAndPassword(String name,String password);

    String login(LoginParams loginParams);

}
