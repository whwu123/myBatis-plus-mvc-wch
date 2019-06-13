package com.baomidou.springmvc.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.baomidou.springmvc.mapper.system.UserMapper;
import com.baomidou.springmvc.model.system.User;
import com.baomidou.springmvc.service.system.IUserService;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


}