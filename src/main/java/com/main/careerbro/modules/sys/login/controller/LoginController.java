package com.main.careerbro.modules.sys.login.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxEnum;
import com.main.careerbro.common.jason.AjaxJson;
import com.main.careerbro.common.redis.RedisServiceImpl;
import com.main.careerbro.common.web.BaseController;
import com.main.careerbro.modules.sys.login.dao.LoginDao;
import com.main.careerbro.modules.sys.login.service.LoginService;
import com.main.careerbro.modules.user.entity.User;
import com.main.careerbro.modules.user.service.UserService;
import lombok.NonNull;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;


@RestController
@RequestMapping("sys")
public class LoginController extends BaseController{
    @Autowired
    private WxMaService wxMaService;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisServiceImpl redisService;
    private static long Time = 86400;//一天

    /**
     * 微信发送jcode进行接口登录
     */
    @RequestMapping(method = RequestMethod.GET,value = "login/{jcode}")
    public AjaxJson login(@PathVariable @NonNull String jcode){
        String token = null;
        try {
            System.out.println(jcode);
            System.out.println(this.wxMaService.getWxMaConfig().getAppid());
            //获取session
            WxMaJscode2SessionResult session = this.wxMaService.getUserService().getSessionInfo(jcode);
            if (null!=session){
                String openid = session.getOpenid();
                String sessionKey = session.getSessionKey();
                if (!StringUtils.isBlank(openid)&&!StringUtils.isBlank(sessionKey)){
                    User user = userService.getUser(openid);
                    token = DigestUtils.md5Hex(sessionKey+openid);
                    redisService.put(token, openid, Time);
                    LinkedHashMap<String,Object> map = new LinkedHashMap<>();
                    map.put("token",token);
                    //已注册
                    if (null != user){
                        return Ajax.success(map);
                    }
                    //未注册
                    else {
                        return Ajax.error(AjaxEnum.REGISTER_ERROR,map);
                    }
                }
            }

        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        System.out.println("44");
        //获取失败
        return Ajax.error(AjaxEnum.WxMaJscode2SessionResult_ERROR);
    }
}
