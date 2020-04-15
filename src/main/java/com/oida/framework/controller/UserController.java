package com.oida.framework.controller;

import com.oida.framework.annoation.ValidationParam;
import com.oida.framework.core.config.GlobalConfig;
import com.oida.framework.core.shiro.JWTUtil;
import com.oida.framework.dao.entity.User;
import com.oida.framework.service.IUserRoleService;
import com.oida.framework.service.IUserService;
import com.oida.framework.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public Object login(@ValidationParam("account,a") String account,int a){
        User user=userService.getUserInfo(account);
        String token=JWTUtil.createToken(user.getAccount());
        return ResponseUtil.ok(token);
    }

    @GetMapping("/getUserInfo")
    public Object getUserInfo(@RequestHeader(value= GlobalConfig.LOGIN_TOKEN_KEY) String token){
        String account=JWTUtil.getUsername(token);
        User user = userService.getUserInfo(account);
        return ResponseUtil.ok(user);
    }

    @GetMapping("/getRole")
    public Object getRole(){
        return userRoleService.list();
    }

}
