package com.hangout.service.whisper;

import com.hangout.dao.whisper.WhisperDao;
import com.hangout.dao.whisper.WhisperDaoImpl;
import com.hangout.entity.Whisper;

import java.sql.SQLException;
import java.util.ArrayList;

public class WhisperServiceImpl implements WhisperService{
    //业务层调用dao层
    private WhisperDao whisperDao;
    public WhisperServiceImpl(){
        whisperDao = new WhisperDaoImpl();
    }
    public void send(String from_id, String to_id, String content) {

    }

    public ArrayList<Whisper> receive(String to_id) {
        ArrayList<Whisper> whispers = null;
        try {
            whispers = whisperDao.selectWhisper(to_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < whispers.size(); i++) {
            try {
                whisperDao.DeleteWhisper(whispers.get(i).getId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return whispers;
    }
}
