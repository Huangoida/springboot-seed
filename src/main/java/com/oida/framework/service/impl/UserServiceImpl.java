package com.oida.framework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oida.framework.dao.entity.User;
import com.oida.framework.dao.mapper.UserMapper;
import com.oida.framework.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(String account) {
        return userMapper.getUserInfo(account);
    }
}
