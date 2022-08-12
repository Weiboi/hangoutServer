package com.hangout.dao.user;

import com.hangout.dao.BaseDao;
import com.hangout.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    public User getLoginUser(String openid) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if(connection != null)
        {
            String sql = "select * from user where openid = ?";
            Object[] params = {openid};
                rs = BaseDao.execute(connection, pstm, rs, sql, params);
                if(rs.next())
                {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setOpenid(rs.getString("openid"));
                    user.setNickname(rs.getString("nickname"));
                    user.setAvatarUrl(rs.getString("avatar_url"));
                    user.setGender(rs.getBoolean("gender"));
                    user.setAge(rs.getInt("age"));
                    user.setMobile(rs.getString("mobile"));
                }
                BaseDao.closeResource(connection,pstm,rs);
        }
        return user;
    }

    public int setLoginUser(User user) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        int rs = 0;
        if(connection != null)
        {
            String sql = "insert into user(openid,nickname,avatar_url,gender,age,mobile) values(?,?,?,?,?,?)";
            Object[] params = {user.getOpenid(),user.getNickname(),user.getAvatarUrl(),user.getGender(),user.getAge(),user.getMobile()};
            rs = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(connection,pstm,null);
        }
        return rs;
    }
}
