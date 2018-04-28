package com.main.careerbro.modules.user.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.common.web.BaseController;
import com.main.careerbro.modules.user.entity.User;
import com.main.careerbro.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    /**
     * 获取用户信息
     */
    @RequestMapping(method = RequestMethod.GET,value = "user/{id}")
    public AjaxJson user(@PathVariable String id){
        User user = userService.getUser(id);
        user.getSchool();
        return Ajax.success();
    }
    /**
     * 新建用户信息
     */
    @RequestMapping(method = RequestMethod.POST,value = "user")
    public AjaxJson newUser(){
        return Ajax.success();
    }
    /**
     * 更新用户信息
     */
    @RequestMapping(method = RequestMethod.PUT,value = "user")
    public AjaxJson updateUser(){
        return Ajax.success();
    }
    /**
     * 删除用户信息
     */
    @RequestMapping(method = RequestMethod.DELETE,value = "user")
    public AjaxJson deleteUser(){
        return Ajax.success();
    }
}
