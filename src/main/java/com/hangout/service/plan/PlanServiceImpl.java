package com.hangout.service.plan;

import com.alibaba.fastjson.JSONObject;
import com.hangout.dao.plan.PlanDao;
import com.hangout.dao.plan.PlanDaoImpl;
import com.hangout.dao.user.UserDao;
import com.hangout.dao.user.UserDaoImpl;
import com.hangout.entity.Plan;


import java.sql.Date;
import java.sql.SQLException;

public class PlanServiceImpl implements PlanService{
    //业务层调用dao层
    private PlanDao planDao;
    public PlanServiceImpl(){
        planDao = new PlanDaoImpl();
    }


    @Override
    public void setPlanContent(int team_id, String date, String time, String content) {
        Plan plan = null;
        try {
            plan = planDao.selectPlan(team_id,date,time);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(plan != null)
        {
            plan.setContent(content);
            try {
                planDao.updatePlan(plan);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            plan = new Plan();
            plan.setTeamId(team_id);
            plan.setDate(Date.valueOf(date));
            plan.setTime(time);
            plan.setContent(content);
            try {
                planDao.insertPlan(plan);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void setPlanPhoto(int team_id, String date, String time, String photo) {
        Plan plan = null;
        try {
            plan = planDao.selectPlan(team_id,date,time);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(plan != null)
        {
            plan.setPhoto(photo);
            try {
                planDao.updatePlan(plan);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            plan = new Plan();
            plan.setTeamId(team_id);
            plan.setDate(Date.valueOf(date));
            plan.setTime(time);
            plan.setPhoto(photo);
            try {
                planDao.insertPlan(plan);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Plan getPlan(int team_id, String date, String time) {
        Plan plan = null;
        try {
            plan = planDao.selectPlan(team_id,date,time);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(plan == null)
        {
            plan = new Plan();
        }
        return plan;
    }

}
