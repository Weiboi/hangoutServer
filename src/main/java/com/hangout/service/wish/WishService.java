package com.hangout.service.wish;

import com.hangout.entity.Wish;

import java.sql.SQLException;
import java.util.ArrayList;

public interface WishService {
    public ArrayList<Wish> findWish(int teamId);
    public int addWish(int team_id,String user_id,int type,String content);
    public int modifyWish(int team_id,String user_id,int type,String content);
    public int dropWish(int team_id,String user_id,int type,String content);
}
