package com.hangout.servlet.labour;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hangout.entity.Takes;
import com.hangout.service.takes.TakesServiceImpl;
import com.hangout.service.user.UserService;
import com.hangout.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class LabourFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LabourFindServlet--start");
        //常驻
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

        // 1.接收小程序发送的参数
        int teamId = Integer.parseInt(req.getParameter("teamId"));

        // 2.查询labour
        TakesServiceImpl takesService = new TakesServiceImpl();
        ArrayList<Takes> takesArrayList = takesService.findLabour(teamId);

        // 3.设置返回参数
        Writer out = resp.getWriter();
        JSONArray returnData = new JSONArray();
        for (int i = 0; i < takesArrayList.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            UserService userService = new UserServiceImpl();
            jsonObject.put("userName",userService.getUserName(((Takes)takesArrayList.get(i)).getUserId()));
            jsonObject.put("labour",((Takes)takesArrayList.get(i)).getLabour());
        }
        out.write(returnData.toString());

        System.out.println("LabourFindServlet--end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
