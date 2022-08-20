package com.hangout.servlet.team;

import com.alibaba.fastjson.JSONObject;
import com.hangout.entity.Identifier;
import com.hangout.entity.Team;
import com.hangout.service.team.TeamService;
import com.hangout.service.team.TeamServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class TeamCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TeamCreateServlet--start");
        //常驻
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

        // 1.获取小程序参数
        String name = req.getParameter("name");
        String destination = req.getParameter("destination");
        String leaderSessionId = req.getParameter("leaderSessionId");

        // 2.获取leaderId
        ServletContext servletContext = this.getServletContext();
        String leaderId = ((Identifier)servletContext.getAttribute(leaderSessionId)).getOpenId();

        // 3.存储队伍信息
        TeamService teamService = new TeamServiceImpl();
        Team team = teamService.createTeam(name,destination,leaderId);

        // 4.返回队伍id
        Writer out = resp.getWriter();
        JSONObject returnData = new JSONObject();
        returnData.put("teamId",team.getId());
        out.write(returnData.toString());

        System.out.println("TeamCreateServlet--end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
