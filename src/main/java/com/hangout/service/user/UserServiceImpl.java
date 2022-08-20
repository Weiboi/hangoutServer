package com.hangout.service.user;

import com.alibaba.fastjson.JSONObject;
import com.hangout.dao.BaseDao;
import com.hangout.dao.user.UserDao;
import com.hangout.dao.user.UserDaoImpl;
import com.hangout.entity.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService{
    //业务层调用dao层
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    public void login(String openid, String data){
        User user = new User();
        JSONObject json = JSONObject.parseObject(data);

        // 获取到 key 对应的值
        user.setOpenid(openid);
        user.setNickname(json.getString("nickName"));
        user.setAvatarUrl(json.getString("avatarUrl"));
        user.setGender(json.getBooleanValue("gender"));
        try {
            userDao.setLoginUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUserName(String openid) {
        User user = null;
        try {
            user = userDao.getLoginUser(openid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user.getNickname();
    }
}
