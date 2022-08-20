package com.hangout.service.team;

import com.hangout.dao.team.TeamDao;
import com.hangout.dao.team.TeamDaoImpl;
import com.hangout.entity.Team;

import java.sql.SQLException;

public class TeamServiceImpl implements TeamService{
    //业务层调用dao层
    private TeamDao teamDao;
    public TeamServiceImpl(){
        teamDao = new TeamDaoImpl();
    }
    public Team createTeam(String name, String destination, String leader_id) {
        Team team = new Team();
        team.setName(name);
        team.setDestination(destination);
        team.setLeaderId(leader_id);
        try {
            teamDao.insertTeam(team);
            team.setId(teamDao.selectId(name,destination,leader_id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return team;
    }
    public Team modifyTeam(int team_id,String name, String destination, String leader_id) {
        Team team = new Team();
        team.setId(team_id);
        team.setName(name);
        team.setDestination(destination);
        team.setLeaderId(leader_id);
        try {
            teamDao.updateTeam(team);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return team;
    }
}




