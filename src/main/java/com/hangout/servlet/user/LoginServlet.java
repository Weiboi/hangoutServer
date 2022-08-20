package com.hangout.servlet.user;

import com.alibaba.fastjson.JSONObject;
import com.hangout.entity.Identifier;
import com.hangout.service.user.UserService;
import com.hangout.service.user.UserServiceImpl;
import com.hangout.util.MyBase64;
import com.hangout.util.WechatUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

public class LoginServlet extends HttpServlet {
        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet--start");
        //常驻
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
        // 1.接收小程序发送的code
        String code = req.getParameter("code");
        String encryptedData = req.getParameter("encryptedData");
        String iv = req.getParameter("iv");

        // 2.开发者服务器 登录凭证校验接口 appid + secret + code
        JSONObject SessionKeyOpenId = WechatUtil.getSessionKeyOrOpenId(code);

        // 3.接收微信接口服务 获取返回的参数
        String openid = SessionKeyOpenId.getString("openid");
        String session_key = SessionKeyOpenId.getString("session_key");

        System.out.println("openid = " + openid);
        System.out.println("session_key = " + session_key);
        // 4.自定义用户登录态
        //得到context
        ServletContext servletContext = this.getServletContext();
        String sessionId = RandomStringUtils.randomAlphanumeric(25);
        servletContext.setAttribute(sessionId, new Identifier(openid,session_key));

        // 5.返回sessionId
        Writer out = resp.getWriter();
        JSONObject returnData = new JSONObject();
        returnData.put("sessionId",sessionId);
        out.write(returnData.toString());

        // 6.存储用户信息
        if(encryptedData != null && iv != null)
        {
            UserService userService = new UserServiceImpl();
            String data = MyBase64.decryptData(encryptedData,session_key,iv);
            userService.login(openid,data);
        }
        System.out.println("LoginServlet--end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
