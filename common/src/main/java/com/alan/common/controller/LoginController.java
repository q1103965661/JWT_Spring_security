package com.alan.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.ObjectName;

/**
 * @author WangYL
 * @version 1.0
 * @date 2019/9/5 15:45
 */
@RestController
@RequestMapping("/user")
public class LoginController {
    @RequestMapping(value = "/register")
    public Object register(@RequestParam(value = "username")String username){
        return username;
    }

}
