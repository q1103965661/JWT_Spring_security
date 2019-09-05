package com.alan.demo.controller;

import com.alan.demo.domain.User;
import com.alan.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author demo
 * @since 2019-09-03
 */
@Controller
@RequestMapping("/user")
@Api("userController相关api")
public class UserController {
    @Autowired
    private UserService userService;
    @ApiOperation("获取所有用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header",name = "id",value = "用户编号"),
            @ApiImplicitParam(paramType = "query",name = "name",value = "用户姓名")
    })

    @ResponseBody
    @GetMapping(value = "user")
    public Object userLogin(){
        List<User> userList = userService.selectList(null);
        return userList;
    }
}

