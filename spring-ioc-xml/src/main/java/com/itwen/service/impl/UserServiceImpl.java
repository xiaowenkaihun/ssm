package com.itwen.service.impl;

import com.itwen.dao.UserDao;
import com.itwen.service.UserService;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/17 21:04
 * 文件描述：
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
