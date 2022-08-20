package com.hangout.dao.wish;

import com.hangout.entity.Wish;

import java.sql.SQLException;
import java.util.ArrayList;

public interface WishDao {
    public ArrayList<Wish> selectWish(int teamId) throws SQLException;
    public int insertWish(Wish wish) throws SQLException;
    public int updateWish(Wish wish) throws SQLException;
    public int deleteWish(Wish wish) throws SQLException;
}
