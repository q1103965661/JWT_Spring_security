package com.alan.common.controller;

import com.alan.common.model.CurrentUser;
import com.alan.common.utils.JWTUtils;
import com.alan.common.utils.JacksonUtils;
import com.alan.common.utils.ToolUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangYL
 * @version 1.0
 * @date 2019/9/5 14:12
 */
@RestController
public class JWTcontroller {

    @PostMapping("login")
    public Object login(@RequestBody CurrentUser user){
        try {
            return JacksonUtils.obj2json(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "haha";
    }
}
