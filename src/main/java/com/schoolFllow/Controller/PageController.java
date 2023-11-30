package com.schoolFllow.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/to_login")
    public String toLogin(){
        System.out.println("daodenglu");
        return "login";
    }
    @GetMapping("/to_index")
    public String toindex(){
        System.out.println("同 index");
        return "index";
    }
}
