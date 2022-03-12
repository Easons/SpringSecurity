package com.pangpan.springsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = SpringsecurityApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringsecurityApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void test(){

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pwd = passwordEncoder.encode("pwd");
        System.out.println(pwd);
        boolean matches = passwordEncoder.matches("pwd",pwd);
        System.out.println(matches);

    }


}
