package com.itwen.service.serviceimpl;

import com.itwen.dao.UserDao;
import com.itwen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/19 10:46
 * 文件描述：
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
