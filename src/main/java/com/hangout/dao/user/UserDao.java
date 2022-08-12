package com.hangout.dao.user;

import com.hangout.entity.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {

    //得到登录的用户
    public User getLoginUser(String openid) throws SQLException;
    public int setLoginUser(User user) throws SQLException;
}
