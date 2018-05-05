package com.main.careerbro.modules.user.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.common.web.BaseController;
import com.main.careerbro.modules.user.entity.User;
import com.main.careerbro.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    /**
     * 获取用户信息
     * @param: openid
     */
    @RequestMapping(method = RequestMethod.GET,value = "user/{id}")
    public AjaxJson user(@PathVariable String id){
        User user = userService.getUser(id);
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("user",user);
        return Ajax.success(map);
    }
    /**
     * 新建用户信息
     */
    @RequestMapping(method = RequestMethod.POST,value = "user")
    public AjaxJson newUser(User user){
        return Ajax.success();
    }
    /**
     * 更新用户信息
     */
    @RequestMapping(method = RequestMethod.PUT,value = "user")
    public AjaxJson updateUser(@RequestBody User user){
        userService.updateUser(user);
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
