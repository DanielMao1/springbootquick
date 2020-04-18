package com.mzy.springbootquick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//转为json
@ResponseBody
@Controller
public class Hellocontroller {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world quick!";
    }
}
