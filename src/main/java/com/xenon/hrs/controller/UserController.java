package com.xenon.hrs.controller;

import com.alibaba.fastjson.JSON;
import com.xenon.hrs.models.Patient;
import com.xenon.hrs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController
{
    @Autowired
    UserService userService;

    @RequestMapping("/register")
    @ResponseBody
    public String userRegister(HttpServletRequest request, HttpSession session)
    {
        Map<String, String> parameter = new HashMap<>();
        String patientIdentity = request.getParameter("patientIdentity");
        String password1 = request.getParameter("password1");
        String patientName = request.getParameter("patientName");
        String gender = request.getParameter("patientGender");
        int patientGender = 0;
        if (gender.equals("男"))
        {
            patientGender = 1;
        }
        String patientAddress = request.getParameter("patientAddress");
        String patientTel = request.getParameter("patientTel");

        Patient patient = userService.selectPatient(patientIdentity);
        if (null == patient)
        {
            Patient patient1 = new Patient(patientIdentity, password1);
            patient1.setPatientName(patientName);
            patient1.setPatientAddress(patientAddress);
            patient1.setPatientGender(patientGender);
            patient1.setPatientIsBlack(0);
            patient1.setPatientTel(patientTel);
            userService.addPatient(patient1);
            session.setAttribute("patientInfo", patient1);
            parameter.put("status", "ok");
            System.out.println("用户注册成功");
            return JSON.toJSONString(parameter);
        }
        else
        {
            parameter.put("status", "no");
            System.out.println("用户存在,注册失败");
            return JSON.toJSONString(parameter);
        }
    }

    @RequestMapping("/confirm")
    @ResponseBody
    public String userConfirm(HttpServletRequest request, HttpSession session)
    {
        Map<String, String> parameter = new HashMap<>();
        String patientIdentity = request.getParameter("patientIdentity");
        String patientName = request.getParameter("patientName");
        String patientTel = request.getParameter("patientTel");

        Patient patient = userService.selectPatient(patientIdentity);
        if (null == patient)
        {

            parameter.put("status", "inexistence");
            System.out.println("用户不存在,请注册");
            return JSON.toJSONString(parameter);
        }
        else if (patient.getPatientName().equals(patientName) && patient.getPatientTel().equals(patientTel))
        {

            parameter.put("status", "ok");
            System.out.println("用户存在,进行下一步");
            return JSON.toJSONString(parameter);
        }
        else
        {
            parameter.put("status", "informationCheckFail");
            System.out.println("信息错误");
            return JSON.toJSONString(parameter);
        }
    }

    @RequestMapping("/password")
    @ResponseBody
    public String userPasswordModification(HttpServletRequest request, HttpSession session)
    {
        Map<String, String> parameter = new HashMap<>();
        String patientIdentity = request.getParameter("patientIdentity");
        String password1 = request.getParameter("password1");

        Patient patient = userService.selectPatient(patientIdentity);
        if (null != patient)
        {
            patient.setPatientPassword(password1);

            userService.updatePatient(patient);

            session.setAttribute("patientInfo", patient);
            parameter.put("status", "ok");
            System.out.println("修改密码成功");
            return JSON.toJSONString(parameter);
        }
        else
        {
            parameter.put("status", "no");
            System.out.println("失败");
            return JSON.toJSONString(parameter);
        }
    }

    @RequestMapping("/exit")
    @ResponseBody
    public String logout(HttpServletRequest request, HttpSession session)
    {
        Map<String, String> parameter = new HashMap<>();
        String sessionType = request.getParameter("sessionType");
        switch (sessionType)
        {
            case "patient":
                request.getSession().removeAttribute("patientInfo");
                break;
            case "doctor":
                request.getSession().removeAttribute("doctorInfo");
                break;
            case "admin":
                request.getSession().removeAttribute("adminInfo");
                break;
            default:
                break;
        }
        parameter.put("status", "ok");
        System.out.println("完成");
        return JSON.toJSONString(parameter);
    }
}
