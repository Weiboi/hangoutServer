package com.hangout.dao.team;

import com.hangout.entity.Team;

import java.sql.SQLException;

public interface TeamDao {
    public Team selectTeam(String team_id) throws SQLException;
    public int selectId(String name,String destionation,String leader_id) throws SQLException;
    public int updateTeam(Team team) throws SQLException;
    public int insertTeam(Team team) throws SQLException;
}
