package com.hangout.service.takes;

import com.hangout.entity.Takes;

import java.util.ArrayList;

public interface TakesService {
    public void participate(String userId,int team_id);
    public void deliverLabour(String userId,int team_id,String labour);
    public ArrayList<Takes> findLabour(int team_id);
}
