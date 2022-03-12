package com.pangpan.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pangpan
 * @date 2021-11-26
 */
@Controller
public class MainController {

    @RequestMapping(value = {"/home",
            "/**"})
    public String Home()
    {
        return "Home";
    }

    @RequestMapping("/level1")
    public String level1()
    {
        return "vip1";
    }

    @RequestMapping("/level2")
    public String level2()
    {
        return "vip2";
    }

    @RequestMapping("/level3")
    public String level3()
    {
        return "vip3";
    }
}
