package com.schoolFllow.Controller;

import com.schoolFllow.Domain.Dto.AppHttpCodeEnum;
import com.schoolFllow.Domain.Dto.ResponseResult;
import com.schoolFllow.Domain.Entity.User;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableMethodSecurity
public class TestController {
    @GetMapping("/test1")
    public String test1(){
        return "可以看到1";
    }

    /**
     * 测试PreAuthorize注解
     * 使用在类或者方法上，只有拥有指定权限才可以访问
     * String类型的参数：el表达式
     * test:show权限
     * hasRole('test:show')会加上ROLE_变为ROLE_test:show，再与.authorities("ROLE_test:show")进行匹配
     * hasAuthority('test:show'),直接与.authorities("test:show")进行匹配
     */
    @GetMapping("/test2")
//    @PreAuthorize("hasRole('test:show')")
    @PreAuthorize("hasAuthority('test:show')||hasAuthority('test1:show')")
    public String test2(){
        return "可以看到2";
    }


    /**
     *
     * @PostAuthorize()方法返回时的检验
     * "returnObject 就是返回的对象
     */
    @PostAuthorize("returnObject.length()>2")
    @GetMapping("/test3")
    public String test3(){
        return "222";
    }

    /**
     * @PreFilter过滤符合条件的请求
     * @PostFilter过滤符合条件的返回
     */
    @PostFilter("filterObject.length()>2")
    @GetMapping("/test4")
    public List<String> test4(){
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("12");
        list.add("123");
        list.add("1234");
        return list;
    }

    /**
     * @PreFilter过滤符合条件的数据，必须是Collection,map,Array【数据】
     * 不能是单个的值
     */
    @PreFilter(value = "filterObject.length()>2")
    @PostFilter("filterObject.length()<4")
    @PostMapping("test5")
    public List<String> test5(List<String> strings){
        strings.forEach(System.out::println);
        return strings;
    }

    @PreAuthorize("hasAuthority('/alumni/search')")
    @GetMapping("/alumni/search")
    public String test456(){
        return "/alumni/search";
    }
    @PreAuthorize("hasAuthority('/activity')")
    @GetMapping("/activity")
    public ResponseResult<Map<String,String>> test46(){
        Map<String,String> map=new HashMap<>();
        map.put("1","123");
        map.put("2","223");
        map.put("3","323");
        ResponseResult result=ResponseResult.okResult(map);

        return result;
    }
}
