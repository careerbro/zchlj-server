package com.main.careerbro.modules.user.controller;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.common.redis.RedisServiceImpl;
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

    @Autowired
    private RedisServiceImpl redisService;
    /**
     * 获取用户信息
     */
    @RequestMapping(method = RequestMethod.GET,value = "user")
    public AjaxJson user(HttpServletRequest httpServletRequest){
        User user = userService.getUser(redisService.get(httpServletRequest.getParameter("token")).toString());
        user.setOpenid("");
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("user",user);
        return Ajax.success(map);
    }
    /**
     * 新建用户信息
     * 新建成功后返回用户总数
     */
    @RequestMapping(method = RequestMethod.POST,value = "user")
    public AjaxJson newUser(HttpServletRequest httpServletRequest,@RequestBody User user){
        user.setOpenid(redisService.get(httpServletRequest.getParameter("token")).toString());
        userService.saveUser(user);
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("sum",userService.getUserSum(user.getCollegeId()));
        return Ajax.success(map);
    }
    /**
     * 更新用户信息
     */
    @RequestMapping(method = RequestMethod.PUT,value = "user")
    public AjaxJson updateUser(HttpServletRequest httpServletRequest,@RequestBody User user){
        userService.updateUser(user);
        //返回用户信息
        User newUser = userService.getUser(redisService.get(httpServletRequest.getParameter("token")).toString());
        newUser.setOpenid("");
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("user",newUser);
        return Ajax.success(map);
    }
    /**
     * 删除用户信息
     */
    @RequestMapping(method = RequestMethod.DELETE,value = "user")
    public AjaxJson deleteUser(){
        return Ajax.success();
    }

    /**
     * 获取用户总数
     */
//    @RequestMapping(method = RequestMethod.GET,value = "sum")
//    public AjaxJson getUserSum(){
//        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
//        map.put("sum",userService.getUserSum());
//        return Ajax.success(map);
//    }
}
