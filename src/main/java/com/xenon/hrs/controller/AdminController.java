package com.xenon.hrs.controller;

import com.alibaba.fastjson.JSON;
import com.xenon.hrs.models.Vacate;
import com.xenon.hrs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController
{

    @Autowired
    AdminService adminService;

    @RequestMapping("/getVacateByAdminId")
    @ResponseBody
    public List<Vacate> getVacateByAdminId(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String adminId = request.getParameter("adminId");

        List<Vacate> vacate = adminService.getVacate(adminId);
        System.out.println(vacate);

        return vacate;
    }

    @RequestMapping("/submitApproval")
    @ResponseBody
    public String submitApproval(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html; charset=utf-8");
        Map<String, String> parameter = new HashMap<>();

        String vacateId = request.getParameter("vacateId");
        String status = request.getParameter("approval");
        String adminOpinion = request.getParameter("opinion");

        Vacate vacate = new Vacate();
        vacate.setVacateId(Integer.valueOf(vacateId));
        vacate.setStatus(Integer.valueOf(status));
        vacate.setAdminOpinion(adminOpinion);
        // 获取当前时间
        Date currentDate = new Date();
        vacate.setAdminDate(currentDate);

        if (adminService.updateVacate(vacate) == 1)
        {
            parameter.put("status", "ok");
            parameter.put("msg", "您已完成审批");
            return JSON.toJSONString(parameter);
        }
        else
        {
            parameter.put("status", "fail");
            parameter.put("msg", "异常");
            return JSON.toJSONString(parameter);
        }


    }
}
