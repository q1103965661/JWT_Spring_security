package com.alan.demo.service.impl;

import com.alan.demo.domain.User;
import com.alan.demo.mapper.UserMapper;
import com.alan.demo.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author demo
 * @since 2019-09-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
