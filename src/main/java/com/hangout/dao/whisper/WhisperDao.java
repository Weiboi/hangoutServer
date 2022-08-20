package com.hangout.dao.whisper;

import com.hangout.entity.Whisper;

import java.sql.SQLException;
import java.util.ArrayList;

public interface WhisperDao {
    public ArrayList<Whisper> selectWhisper(String toId) throws SQLException;
    public void insertWhisper(String fromId,String toId,String content) throws SQLException;
    public void DeleteWhisper(int id) throws SQLException;
}
