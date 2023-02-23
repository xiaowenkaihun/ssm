package com.itwen.dao.daoimpl;

import com.itwen.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/19 10:47
 * 文件描述：
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
