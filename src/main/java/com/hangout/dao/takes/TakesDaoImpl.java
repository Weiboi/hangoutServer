package com.hangout.dao.takes;

import com.hangout.dao.BaseDao;
import com.hangout.entity.Takes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TakesDaoImpl implements TakesDao{
    public ArrayList<Takes> selectTakes(int teamId) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Takes> takesArrayList = new ArrayList<>();

        if(connection != null)
        {
            String sql = "select * from takes where team_id = ?";
            Object[] params = {teamId};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);

            while(rs.next())
            {
                Takes takes = new Takes();
                takes.setUserId(rs.getString("user_id"));
                takes.setTeamId(rs.getInt("team_id"));
                takes.setLabour(rs.getString("labour"));
                takesArrayList.add(takes);
            }
            BaseDao.closeResource(connection,pstm,rs);
        }
        return takesArrayList;
    }

    public int updateTakes(Takes takes) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        int rs = 0;
        if(connection != null)
        {
            String sql = "update takes set labour=? where user_id=? and team_id=?";
            Object[] params = {takes.getLabour(),takes.getUserId(),takes.getTeamId()};
            rs = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(connection,pstm,null);
        }
        return rs;
    }

    public int insertTakes(Takes takes) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        int rs = 0;
        if(connection != null)
        {
            String sql = "insert into takes(user_id,team_id,labour) values(?,?,?)";
            Object[] params = {takes.getUserId(),takes.getTeamId(),takes.getLabour()};
            rs = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(connection,pstm,null);
        }
        return rs;
    }
}
