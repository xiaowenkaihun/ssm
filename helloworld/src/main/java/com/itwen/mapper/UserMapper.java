package com.itwen.mapper;

import com.itwen.pojo.User;

import java.util.List;

public interface UserMapper {
    int insertUser();

    int updateUser();

    List<User> selectAll();

}
