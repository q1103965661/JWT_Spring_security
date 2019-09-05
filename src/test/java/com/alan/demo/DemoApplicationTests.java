package com.alan.demo;

import com.alan.demo.domain.User;
import com.alan.demo.service.UserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
/*@Rollback(value = false)
@Transactional(transactionManager = "transactionManager")*/
public class DemoApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    public void contextLoads() {
        //查询所有用户
        List<User> users = userService.selectList(null);
        System.out.println(users);
    }
    @Test
    public void selectOne(){
        //查询单个用户，id为1
        User user = userService.selectById(1);
        System.out.println(user);
    }
    @Test
    public void selectByName(){
        //通过名字查询单个用户信息
        User user = userService.selectOne(new EntityWrapper<User>().eq("name", "张三"));
        System.out.println(user);
    }
    @Test
    public void selectBy(){
        //查询id>1的用户
        List<User> userList = userService.selectList(new EntityWrapper<User>().gt("id", 1));
        System.out.println(userList);

    }
    @Test
    public void updateById(){
        //修改ID为1的用户名
        User user = userService.selectById(1);
        user.setName("张三2");
        boolean b = userService.updateById(user);
        System.out.println(b);
    }
    @Test
    public void insertUser(){
        //添加用户
       /* User user = new User();
        user.setName("杨涵");
        boolean insert = userService.insert(user);
        System.out.println(insert);*/
    }
    @Test
    public void page(){
        //分页查询
        Page<User> userPage = new Page<>();
        userPage.setCurrent(2);
        userPage.setSize(1);
        Page<User> userList = userService.selectPage(userPage,new EntityWrapper<User>().gt("id",1));
        System.out.println(userList.getRecords());
    }
}
