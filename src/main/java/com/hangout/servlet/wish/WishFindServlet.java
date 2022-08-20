package com.hangout.servlet.wish;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hangout.entity.Identifier;
import com.hangout.entity.Whisper;
import com.hangout.entity.Wish;
import com.hangout.service.user.UserService;
import com.hangout.service.user.UserServiceImpl;
import com.hangout.service.whisper.WhisperServiceImpl;
import com.hangout.service.wish.WishServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class WishFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("WishFindServlet--start");
        //常驻
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

        // 1.接收小程序发送的参数
        int teamId = Integer.parseInt(req.getParameter("teamId"));

        // 2.查询wish
        WishServiceImpl wishService = new WishServiceImpl();
        ArrayList<Wish> wishes = wishService.findWish(teamId);

        // 3.设置返回参数
        Writer out = resp.getWriter();
        JSONArray returnData = new JSONArray();
        for (int i = 0; i < wishes.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            UserService userService = new UserServiceImpl();
            jsonObject.put("userName",userService.getUserName(((Wish)wishes.get(i)).getUserId()));
            jsonObject.put("content",((Wish)wishes.get(i)).getContent());
            jsonObject.put("type",((Wish)wishes.get(i)).getType());
        }
        out.write(returnData.toString());

        System.out.println("WishFindServlet--end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
