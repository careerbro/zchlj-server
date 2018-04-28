package com.main.careerbro.modules.user.service;

import com.main.careerbro.modules.sys.login.dao.LoginDao;
import com.main.careerbro.modules.user.dao.UserDao;
import com.main.careerbro.modules.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public User getUser(String openid){
        return userDao.getUser(openid);
    }

}
