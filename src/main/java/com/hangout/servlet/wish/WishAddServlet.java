package com.hangout.servlet.wish;

import com.hangout.entity.Identifier;
import com.hangout.service.whisper.WhisperServiceImpl;
import com.hangout.service.wish.WishServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WishAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("WishAddServlet--start");
        //常驻
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

        // 1.接收小程序发送的参数
        int teamId = Integer.parseInt(req.getParameter("teamId"));
        String userSessionId = req.getParameter("userSessionId");
        int type = Integer.parseInt(req.getParameter("type"));
        String content = req.getParameter("content");

        // 2.转换成openid
        ServletContext servletContext = this.getServletContext();
        String userId = ((Identifier)servletContext.getAttribute(userSessionId)).getOpenId();

        // 3.存储wish
        WishServiceImpl wishService = new WishServiceImpl();
        wishService.addWish(teamId,userId,type,content);

        System.out.println("WishAddServlet--end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
