package com.main.careerbro.modules.sys.interceptor;

import com.main.careerbro.common.jason.Ajax;
import com.main.careerbro.common.jason.AjaxEnum;
import com.main.careerbro.common.redis.RedisServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    public RedisServiceImpl redisService;
//    开始进入请求地址拦截
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object object) throws Exception{
        //日志
        logger.debug(httpServletRequest.getRequestURI());

        String token = httpServletRequest.getParameter("token");
        if (!StringUtils.isBlank(token)){
            boolean isLogin = redisService.isKeyExists(token);
            if (isLogin){
                return true;
            }
            else {
                Ajax.error(AjaxEnum.TOKEN_ERROR);
                return false;
            }
        }
        else {
            Ajax.error(AjaxEnum.NO_TOKEN);
            return false;
        }
//        System.out.println("进入到了TokenInterceptor");
    }

//    处理请求完成后视图渲染之前的处理操作
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object object,ModelAndView modelAndView) throws Exception {
    }

//    视图渲染之后的操作
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object handler, Exception ex) throws Exception {
    }
}
