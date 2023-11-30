package com.schoolFllow.Controller;

import com.schoolFllow.Domain.Dto.LoginParams;
import com.schoolFllow.Service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Resource
    private UserService userService;

    /**
     * 登录方法
     * @return token
     * 用户再次访问，需要带上请求头的token，证明已经认证过
     */
    @PostMapping("/login")
    public String login(@RequestBody LoginParams loginParams){
        String token=userService.login(loginParams);
        return token;
    }
}
