package com.hangout.dao.wish;

import com.hangout.dao.BaseDao;
import com.hangout.entity.Whisper;
import com.hangout.entity.Wish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WishDaoImpl implements WishDao{
    public ArrayList<Wish> selectWish(int teamId) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Wish> wishes = new ArrayList<>();
        if(connection != null)
        {
            String sql = "select * from wish where team_id = ?";
            Object[] params = {teamId};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while(rs.next())
            {
                Wish wish = new Wish();
                wish.setTeam_id(rs.getInt("team_id"));
                wish.setUserId(rs.getString("user_id"));
                wish.setType(rs.getInt("type"));
                wish.setContent(rs.getString("content"));
                wishes.add(wish);
            }
            BaseDao.closeResource(connection,pstm,rs);
        }
        return wishes;
    }

    public int insertWish(Wish wish) throws SQLException{
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        int rs = 0;
        if(connection != null)
        {
            String sql = "insert into wish(team_id,user_id,type,content) values(?,?,?,?)";
            Object[] params = {wish.getTeam_id(),wish.getUserId(),wish.getType(),wish.getContent()};
            rs = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(connection,pstm,null);
        }
        return rs;
    }

    public int updateWish(Wish wish) throws SQLException{
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        int rs = 0;
        if(connection != null)
        {
            String sql = "update wish set content=? where team_id=? and user_id=? and type=?";
            Object[] params = {wish.getContent(),wish.getTeam_id(),wish.getUserId(),wish.getType()};
            rs = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(connection,pstm,null);
        }
        return rs;
    }

    public int deleteWish(Wish wish) throws SQLException{
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        int rs = 0;
        if(connection != null)
        {
            String sql = "delete from whisper where team_id = ? and user_id = ? and type = ? and content = ?";
            Object[] params = {wish.getTeam_id(),wish.getUserId(),wish.getType(),wish.getContent()};
            rs = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(connection,pstm,null);
        }
        return rs;
    }
}
