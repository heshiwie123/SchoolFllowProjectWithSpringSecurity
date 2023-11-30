package com.schoolFllow;

import com.schoolFllow.Domain.Entity.Identity;
import com.schoolFllow.Domain.Entity.User;
import com.schoolFllow.Mapper.ActivityMapper;
import com.schoolFllow.Mapper.AlumniMapper;
import com.schoolFllow.Mapper.IdentityMapper;
import com.schoolFllow.Mapper.UserMapper;
import com.schoolFllow.Web.JwtUtils;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

@SpringBootTest
public class newTest {
    @Resource
    private AlumniMapper alumniMapper;
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private IdentityMapper identityMapper;
    @Resource
    private JwtUtils jwtUtils;

    @Test
    public void dddterst() {

        Set<Integer> ids = new HashSet<>();
        ids.add(3);
        System.out.println(identityMapper.selectFunctionByIdentityIdS(ids));
    }

    @Test
    public void testAC() {
        System.out.println(activityMapper.selectAll());
    }

    @Test
    public void testAC2() {
        System.out.println(activityMapper.selectByName("书"));
    }

    @Test
    public void test555() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user;
        user = userMapper.selectById(2);
        System.out.println(user.getPassword());
        System.out.println("$2a$10$usNOm3tk.w4wk9FLonzPC.DwbEnB97A9OuK4ajZJX1bsY5OoW6ykC");
        System.out.println(encoder.matches("123", "$2a$10$usNOm3tk.w4wk9FLonzPC.DwbEnB97A9OuK4ajZJX1bsY5OoW6ykC"));
    }

    @Test
    public void testJWT() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 54);
        map.put("password", 456);
        map.put("prems", Arrays.asList("/123", "/456", "/789"));
        System.out.println(jwtUtils.creatToken(map));
    }
    @Test
    public void testJET2(){
        System.out.println(jwtUtils.parseToken(""));
    }
}
