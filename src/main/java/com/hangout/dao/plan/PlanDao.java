package com.hangout.dao.plan;

import com.hangout.entity.Plan;

import java.sql.SQLException;

public interface PlanDao {
    public Plan selectPlan(int team_id,String date,String time) throws SQLException;
    public int updatePlan(Plan plan) throws SQLException;
    public int insertPlan(Plan plan) throws SQLException;
}
