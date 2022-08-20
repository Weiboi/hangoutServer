package com.hangout.service.takes;


import com.hangout.dao.takes.TakesDao;
import com.hangout.dao.takes.TakesDaoImpl;
import com.hangout.entity.Takes;

import java.sql.SQLException;
import java.util.ArrayList;

public class TakesServiceImpl implements TakesService{
    private TakesDao takesDao;
    public TakesServiceImpl(){
        takesDao = new TakesDaoImpl();
    }

    public void participate(String userId, int team_id) {
        Takes takes = new Takes();
        takes.setUserId(userId);
        takes.setTeamId(team_id);
        try {
            takesDao.insertTakes(takes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deliverLabour(String userId, int team_id, String labour) {
        Takes takes = new Takes();
        takes.setUserId(userId);
        takes.setTeamId(team_id);
        takes.setLabour(labour);
        try {
            takesDao.updateTakes(takes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Takes> findLabour(int team_id) {
        try {
            return takesDao.selectTakes(team_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
