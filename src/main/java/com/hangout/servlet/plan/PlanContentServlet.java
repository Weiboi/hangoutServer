package com.hangout.servlet.plan;

import com.alibaba.fastjson.JSONObject;
import com.hangout.entity.Plan;
import com.hangout.service.plan.PlanService;
import com.hangout.service.plan.PlanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class PlanContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PlanContentServlet--start");
        //常驻
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
        // 1.接收小程序发送的参数
        int journeyId = Integer.parseInt(req.getParameter("journeyId"));
        String planDate = req.getParameter("planDate");
        String planTime = req.getParameter("planTime");
        String planContent = req.getParameter("planContent");//非必需
        Plan plan = null;
        PlanService planService = new PlanServiceImpl();

        // 2.存储planContent
        if(planContent!= null)
        {
            planService.setPlanContent(journeyId,planDate,planTime,planContent);
        }

        // 3.查询plan信息
            plan = planService.getPlan(journeyId,planDate,planTime);
        // 4.返回plan信息
        Writer out = resp.getWriter();
        JSONObject returnData = new JSONObject();
        returnData.put("planContent",plan.getContent());
        out.write(returnData.toString());

        System.out.println("PlanContentServlet--end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
