package com.hangout.dao.takes;


import com.hangout.entity.Takes;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TakesDao {
    public ArrayList<Takes> selectTakes(int teamId) throws SQLException;
    public int updateTakes(Takes takes) throws SQLException;
    public int insertTakes(Takes takes) throws SQLException;
}
