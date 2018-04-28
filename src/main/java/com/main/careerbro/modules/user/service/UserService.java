package com.main.careerbro.modules.user.service;

import com.main.careerbro.modules.sys.login.dao.LoginDao;
import com.main.careerbro.modules.user.dao.UserDao;
import com.main.careerbro.modules.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUser(String id){
        return userDao.getUser(id);
    }

    @Transactional
    public void saveUser(User user){
         userDao.saveUser(user);
    }

    @Transactional
    public void updateUser(User user){
        userDao.updateUser(user);
    }

    @Transactional
    public void deleteUser(String id){
        userDao.deleteUser(id);
    }
}
