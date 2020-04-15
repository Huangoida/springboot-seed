package com.oida.framework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oida.framework.dao.entity.UserRole;
import com.oida.framework.dao.mapper.UserRoleMapper;
import com.oida.framework.service.IUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper,UserRole> implements IUserRoleService {
}
