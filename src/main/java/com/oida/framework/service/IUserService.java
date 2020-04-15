package com.oida.framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oida.framework.dao.entity.User;

public interface IUserService extends IService<User> {

    User getUserInfo(String account);

}
