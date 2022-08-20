package com.hangout.service.wish;


import com.hangout.dao.wish.WishDao;
import com.hangout.dao.wish.WishDaoImpl;
import com.hangout.entity.Wish;

import java.sql.SQLException;
import java.util.ArrayList;

public class WishServiceImpl implements WishService{
    private WishDao wishDao;
    public WishServiceImpl(){
        wishDao = new WishDaoImpl();
    }

    public ArrayList<Wish> findWish(int teamId) {
        try {
            return wishDao.selectWish(teamId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int addWish(int team_id, String user_id, int type, String content) {
        Wish wish = new Wish();
        wish.setTeam_id(team_id);
        wish.setUserId(user_id);
        wish.setType(type);
        wish.setContent(content);
        try {
            return wishDao.insertWish(wish);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modifyWish(int team_id, String user_id, int type, String content) {
        Wish wish = new Wish();
        wish.setTeam_id(team_id);
        wish.setUserId(user_id);
        wish.setType(type);
        wish.setContent(content);
        try {
            return wishDao.updateWish(wish);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int dropWish(int team_id, String user_id, int type, String content) {
        Wish wish = new Wish();
        wish.setTeam_id(team_id);
        wish.setUserId(user_id);
        wish.setType(type);
        wish.setContent(content);
        try {
            return wishDao.deleteWish(wish);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
