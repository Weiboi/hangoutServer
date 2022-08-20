package com.hangout.servlet.whisper;

import com.hangout.entity.Identifier;
import com.hangout.service.whisper.WhisperService;
import com.hangout.service.whisper.WhisperServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WhisperSendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("WhisperSendServlet--start");
        //常驻
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

        // 1.接收小程序发送的参数
        String fromSessionId = req.getParameter("fromSessionId");
        String toSessionId = req.getParameter("toSessionId");
        String content = req.getParameter("content");

        // 2.转换成openid
        ServletContext servletContext = this.getServletContext();
        String fromId = ((Identifier)servletContext.getAttribute(fromSessionId)).getOpenId();
        String toId = ((Identifier)servletContext.getAttribute(toSessionId)).getOpenId();

        // 3.存储whisper
        WhisperServiceImpl whisperService = new WhisperServiceImpl();
        whisperService.send(fromId,toId,content);

        System.out.println("WhisperSendServlet--end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
