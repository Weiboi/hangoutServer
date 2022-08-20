package com.hangout.dao.team;

import com.hangout.dao.BaseDao;
import com.hangout.entity.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamDaoImpl implements TeamDao{
    public Team selectTeam(String team_id) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Team team = null;

        if(connection != null)
        {
            String sql = "select * from team where id = ?";
            Object[] params = {team_id};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);

            if(rs.next())
            {
                team = new Team();
                team.setId(rs.getInt("id"));
                team.setName(rs.getString("name"));
                team.setDestination(rs.getString("time"));
                team.setLeaderId(rs.getString("leader_id"));
            }
            BaseDao.closeResource(connection,pstm,rs);
        }
        return team;
    }

    public int selectId(String name, String destionation, String leader_id) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int team_id = 0;

        if(connection != null)
        {
            String sql = "select * from team where name = ? and destionation = ? and leader_id = ?";
            Object[] params = {name,destionation,leader_id};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);

            if(rs.next())
            {
                team_id = rs.getInt("id");
            }
            BaseDao.closeResource(connection,pstm,rs);
        }
        return team_id;
    }

    public int updateTeam(Team team) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        int rs = 0;
        if(connection != null)
        {
            String sql = "insert into team(name,destination,leader_id) values(?,?,?)";
            Object[] params = {team.getName(),team.getDestination(),team.getLeaderId()};
            rs = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(connection,pstm,null);
        }
        return rs;
    }

    public int insertTeam(Team team) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        int rs = 0;
        if(connection != null)
        {
            String sql = "update team set name=?, destination=?,leader_id=? where id=?";
            Object[] params = {team.getName(),team.getDestination(),team.getLeaderId(),team.getId()};
            rs = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(connection,pstm,null);
        }
        return rs;
    }
}
