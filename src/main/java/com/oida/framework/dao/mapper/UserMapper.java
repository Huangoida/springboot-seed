package com.oida.framework.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oida.framework.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {


    User getUserInfo(String account);
}