package com.nondo.springboot.user.dao;

import com.nondo.springboot.user.bean.User;

public interface UserDao {
    int addUser(User user);

    int deleteUserById(int id);

    int updateUser(User user);

    User queryUserById(int id);
}
