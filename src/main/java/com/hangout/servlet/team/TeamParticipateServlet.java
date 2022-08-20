package com.hangout.servlet.team;

import com.hangout.entity.Identifier;
import com.hangout.service.takes.TakesServiceImpl;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeamParticipateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TeamCreateServlet--start");
        //常驻
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

        // 1.获取小程序参数
        String sessionId = req.getParameter("sessionId");
        int teamId = Integer.parseInt(req.getParameter("teamId"));

        // 2.获取user_id
        ServletContext servletContext = this.getServletContext();
        String user_id = ((Identifier)servletContext.getAttribute(sessionId)).getOpenId();

        // 3.存储参队信息
        TakesServiceImpl takesService = new TakesServiceImpl();
        takesService.participate(user_id,teamId);

        System.out.println("TeamCreateServlet--end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
