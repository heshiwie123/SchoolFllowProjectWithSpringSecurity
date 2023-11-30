package com.schoolFllow;

import com.schoolFllow.Web.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.HashMap;
@SpringBootTest
public class ddddTest {

    @Autowired
    private JwtUtils jwtUtils;
    @Test
    public void testJWT() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 54L);
        map.put("password", "456");
        map.put("prems", Arrays.asList("123", "56", "789"));
        System.out.println(jwtUtils.creatToken(map));
    }
    @Test
    public void testJET2(){
        System.out.println(jwtUtils.parseToken("eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjQ1NiIsInByZW1zIjpbIjEyMyIsIjU2IiwiNzg5Il0sImlkIjo1NCwiZXhwIjoxNzAxMTA2NzMyLCJpYXQiOjE3MDEwOTc3MzJ9.-bGEtARrW27vIKZrViKehLD21LXj62U7AuAVqKJY60E"));
    }
}
