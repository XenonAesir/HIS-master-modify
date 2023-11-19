package com.xenon.hrs.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.GsonBuilder;
import com.xenon.hrs.DTO.ReserveInfoDto;
import com.xenon.hrs.DTO.ReserveTableDto;
import com.xenon.hrs.models.Doctor;
import com.xenon.hrs.models.Patient;
import com.xenon.hrs.models.Vacate;
import com.xenon.hrs.service.DoctorService;
import com.xenon.hrs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DoctorController
{
    @Autowired
    DoctorService doctorService;

    @RequestMapping("/getDoctorAppointments")
    @ResponseBody
    public List<ReserveInfoDto> getDoctorAppointments(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String doctorId = request.getParameter("doctorId");

        return doctorService.getThisWeekReserve(doctorId);

    }

    @RequestMapping("/insertVacate")
    @ResponseBody
    public String insertVacate(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html; charset=utf-8");
        Map<String, String> parameter = new HashMap<>();

        String doctorId = request.getParameter("doctorId");
        String description = request.getParameter("description");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date vacateDate = null;
        try
        {
            vacateDate = sdf.parse(request.getParameter("vacateDate"));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        // 获取当前时间
        Date currentDate = new Date();

        Doctor doctor = doctorService.findById(doctorId);
        // 假设部门号为 DEP0001 的字符串表示为 departmentId
        String departmentId = doctor.getDepartmentId();

        // 获取部门ID的后三位
        String departmentLastThree = departmentId.substring(departmentId.length() - 3);

        // 拼凑出其部门所属管理员ID
        String adminId = "A001" + departmentLastThree;

        Vacate vacate = new Vacate();
        vacate.setDoctorId(doctorId);
        vacate.setDescription(description);
        vacate.setVacateDate(vacateDate);
        vacate.setStatus(0);
        vacate.setApplyDate(currentDate);
        vacate.setAdminId(adminId);

        System.out.println(vacate);

        int statusCode = doctorService.applyVacate(vacate);

        if (statusCode == 1)
        {
            parameter.put("status", "ok");
            parameter.put("msg", "您已提交到部门管理员处，请等待处理！");
            return JSON.toJSONString(parameter);
        }
        else
        {
            parameter.put("status", "fail");
            parameter.put("msg", "异常！");
            return JSON.toJSONString(parameter);
        }


    }

}
