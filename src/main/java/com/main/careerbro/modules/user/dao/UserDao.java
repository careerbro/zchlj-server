package com.main.careerbro.modules.user.dao;

import com.main.careerbro.modules.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    /**
     * 根据openID返回用户
     * @param openid
     * @return User
     */
    public User getUser(String openid);
}

