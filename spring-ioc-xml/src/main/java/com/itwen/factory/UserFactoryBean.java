package com.itwen.factory;

import com.itwen.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/17 20:39
 * 文件描述：
 */
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
