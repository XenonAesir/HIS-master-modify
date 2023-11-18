package com.xenon.hrs.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.GsonBuilder;
import com.xenon.hrs.DTO.ReserveInfoDto;
import com.xenon.hrs.DTO.ReserveTableDto;
import com.xenon.hrs.models.Patient;
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

}
