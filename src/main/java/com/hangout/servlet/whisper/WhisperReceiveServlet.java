package com.hangout.servlet.whisper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hangout.entity.Identifier;
import com.hangout.entity.Whisper;
import com.hangout.service.user.UserService;
import com.hangout.service.user.UserServiceImpl;
import com.hangout.service.whisper.WhisperServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class WhisperReceiveServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("WhisperReceiveServlet--start");
        //常驻
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

        // 1.接收小程序发送的参数
        String toSessionId = req.getParameter("toSessionId");

        // 2.转换成openid
        ServletContext servletContext = this.getServletContext();
        String toId = ((Identifier)servletContext.getAttribute(toSessionId)).getOpenId();

        // 3.查询whisper
        WhisperServiceImpl whisperService = new WhisperServiceImpl();
        ArrayList<Whisper> whispers = whisperService.receive(toId);

        // 4.设置返回参数
        Writer out = resp.getWriter();
        JSONArray returnData = new JSONArray();
        for (int i = 0; i < whispers.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            UserService userService = new UserServiceImpl();
            jsonObject.put("fromUserName",userService.getUserName(((Whisper)whispers.get(i)).getFromId()));
            jsonObject.put("content",((Whisper)whispers.get(i)).getContent());
        }
        out.write(returnData.toString());

        System.out.println("WhisperReceiveServlet--end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
