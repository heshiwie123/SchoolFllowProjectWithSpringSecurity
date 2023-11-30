package com.schoolFllow;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptExample {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // 编码 "123"
        String encodedPassword123 = encoder.encode("123");
        System.out.println("Encoded Password for '123':" + encodedPassword123);

        System.out.println(encoder.matches("123","$2a$10$usNOm3tk.w4wk9FLonzPC.DwbEnB97A9OuK4ajZJX1bsY5OoW6ykC"));
    }
}
