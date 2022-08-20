package com.hangout.dao.plan;

import com.hangout.dao.BaseDao;
import com.hangout.entity.Plan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanDaoImpl implements PlanDao{
    public Plan selectPlan(int team_id, String date, String time) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Plan plan = null;

        if(connection != null)
        {
            String sql = "select * from plan where team_id = ? and date = ? and time = ?";
            Object[] params = {team_id,date,time};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);

            if(rs.next())
            {
                plan = new Plan();
                plan.setId(rs.getInt("id"));
                plan.setDate(rs.getDate("date"));
                plan.setTime(rs.getString("time"));
                plan.setTeamId(rs.getInt("team_id"));
                plan.setContent(rs.getString("content"));
                plan.setPhoto(rs.getString("photo_url"));
            }
            BaseDao.closeResource(connection,pstm,rs);
        }
        return plan;
    }

    public int insertPlan(Plan plan) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        int rs = 0;
        if(connection != null)
        {
            String sql = "insert into plan(date,time,team_id,content,photo_url) values(?,?,?,?,?)";
            Object[] params = {plan.getDate(),plan.getTime(),plan.getTeamId(),plan.getContent(),plan.getPhoto()};
            rs = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(connection,pstm,null);
        }
        return rs;
    }

    public int updatePlan(Plan plan) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        int rs = 0;
        if(connection != null)
        {
            String sql = "update plan set content=?, photo_url=? where team_id=? and date=? and time=?";
            Object[] params = {plan.getContent(),plan.getPhoto(),plan.getTeamId(),plan.getDate(),plan.getTime()};
            rs = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(connection,pstm,null);
        }
        return rs;
    }
}
