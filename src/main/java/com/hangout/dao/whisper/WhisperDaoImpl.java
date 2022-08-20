package com.hangout.dao.whisper;

import com.hangout.dao.BaseDao;
import com.hangout.entity.Whisper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WhisperDaoImpl implements WhisperDao{
    public ArrayList<Whisper> selectWhisper(String toId) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
       ArrayList<Whisper> whispers = new ArrayList<>();

        if(connection != null)
        {
            String sql = "select * from whisper where to_id = ?";
            Object[] params = {toId};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);

            while(rs.next())
            {
                Whisper whisper = new Whisper();
                whisper.setId(rs.getInt("id"));
                whisper.setFromId(rs.getString("from_id"));
                whisper.setToId(rs.getString("to_id"));
                whisper.setContent(rs.getString("content"));
                whispers.add(whisper);
            }
            BaseDao.closeResource(connection,pstm,rs);
        }
        return whispers;
    }

    public void insertWhisper(String fromId, String toId, String content) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        int rs = 0;
        if(connection != null)
        {
            String sql = "insert into whisper(from_id,to_id,content) values(?,?,?)";
            Object[] params = {fromId,toId,content};
            rs = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(connection,pstm,null);
        }
    }

    public void DeleteWhisper(int id) throws SQLException {
        Connection connection = BaseDao.getConnection();
        PreparedStatement pstm = null;
        int rs = 0;
        if(connection != null)
        {
            String sql = "delete from whisper where id = ?";
            Object[] params = {id};
            rs = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(connection,pstm,null);
        }
    }
}
