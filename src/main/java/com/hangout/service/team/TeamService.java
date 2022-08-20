package com.hangout.service.team;

import com.hangout.entity.Team;

public interface TeamService {
    public Team createTeam(String name, String destination, String leader_id);
    public Team modifyTeam(int team_id,String name, String destination, String leader_id);
}
