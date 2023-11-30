package com.schoolFllow.Web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.schoolFllow.Domain.Entity.Function;
import com.schoolFllow.Domain.Entity.Identity;
import com.schoolFllow.Domain.Entity.User;
import com.schoolFllow.Mapper.IdentityMapper;
import com.schoolFllow.Mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {
    /**
     * 根据用户命查询用户
     * 返回UserDetails，SpringSecurity定义的，用于存储用户信息
     * MyUserDetailsService就是UserDetailsService（MyUserDetailsService implements UserDetailsService）
     *
     * @throws UsernameNotFoundException
     */
    @Resource
    private UserMapper userMapper;
    @Resource
    private IdentityMapper identityMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername========>,要登陆的用户用户名：{}", username);

        //根据用户名获取用户
        User user=userMapper.selectUserByUsername(username);
        log.info("登录的用户========》{}",user);

        //查询用户的权限信息
        if(user!=null){
            Set<Identity> identitySet =user.getIdentitySet();
            //存储身份信息，批量查询而不是重复查询数据库
            Set<Integer> identityIds= new HashSet<>(identitySet.size());
            for(Identity identity:identitySet){
                identityIds.add(identity.getId());
            }
            log.info("登录的用户身份============》{}",identityIds);
            //将身份id集合用于查询权限
            Set<Function> functions=identityMapper.selectFunctionByIdentityIdS(identityIds);
            log.info("登录的用户的权限================》{}",functions);
            Set<String> strings=new HashSet<>(functions.size());
            for(Function function:functions){
                strings.add(function.getPerms());
            }
            //存入user的funs中
            user.setFuncs(strings);
        }

    return user;
    }
}















