package com.hangout.servlet.plan;

import com.alibaba.fastjson.JSONObject;
import com.hangout.entity.Plan;
import com.hangout.service.plan.PlanService;
import com.hangout.service.plan.PlanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("uploadServlet")
@MultipartConfig
public class PlanPhotoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求 编码格式
        req.setCharacterEncoding("UTF-8");


        // 1. 获取普通表单项
        int journeyId = Integer.parseInt(req.getParameter("journeyId"));
        String planDate = req.getParameter("planDate");
        String planTime = req.getParameter("planTime");
        String name = req.getParameter("name");
        PlanService planService = new PlanServiceImpl();

        // 2. 获取Part对象，在服务器本地存储图片
        Part part = req.getPart(name);
        String fileName = part.getSubmittedFileName();
        String realPath = req.getServletContext().getRealPath("/");
        String photo = realPath + "img/" + journeyId + planDate + planTime + "/" + fileName;
        part.write(photo);

        // 3. 将图片路径存储在数据库
        planService.setPlanPhoto(journeyId,planDate,planTime,photo);
    }
}
