package com.hangout.service.plan;

import com.hangout.entity.Plan;

public interface PlanService {
    public void setPlanContent(int team_id, String date, String time,String content);
    public void setPlanPhoto(int team_id, String date, String time,String photo);
    public Plan getPlan(int team_id, String date, String time);
}

