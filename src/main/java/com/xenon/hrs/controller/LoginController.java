package com.xenon.hrs.controller;

import com.alibaba.fastjson.JSON;
import com.xenon.hrs.models.Admin;
import com.xenon.hrs.models.Doctor;
import com.xenon.hrs.models.Patient;
import com.xenon.hrs.service.LoginService;
import com.xenon.hrs.tool.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class LoginController
{
    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public String userLogin(HttpServletRequest request, HttpServletResponse response)
    {
        Map<String, String> parameter = new HashMap<>();
        String patientIdentity = request.getParameter("patientIdentity");
        String password = request.getParameter("password");
        Patient patient = loginService.selectPatient(patientIdentity);
        System.out.println("登录密码:" + password);
        if (null == patient)
        {
            parameter.put("status", "null");
            parameter.put("msg", "用户登录失败,无此用户");
            System.out.println("用户登录失败,无此用户");
            return JSON.toJSONString(parameter);
        }
        else if (!Objects.equals(patient.getPatientPassword(), password))
        {
            System.out.println("密码:" + patient.getPatientPassword());
            parameter.put("status", "fail");
            parameter.put("msg", "用户登录失败,密码错误");
            System.out.println("用户登录失败,密码错误");
            return JSON.toJSONString(parameter);
        }
        else
        {
            request.getSession().setAttribute("patientInfo", patient);
            parameter.put("status", "ok");
            parameter.put("msg", "用户登录成功");
            parameter.put("data", patient.getPatientIdentity());
            String token = JwtUtils.getToken(patientIdentity);
            parameter.put("token", token);
            System.out.println("用户登录成功");
            return JSON.toJSONString(parameter);
        }
    }

    @RequestMapping("/staff_login")
    @ResponseBody
    public String staffLogin(HttpServletRequest request, HttpServletResponse response)
    {
        Map<String, String> parameter = new HashMap<>();
        String staffId = request.getParameter("staffId");
        String password = request.getParameter("password");
        System.out.println("staff_login" + staffId + "    " + password);

        //判断员工类型
        //A开头：管理人员
        if (staffId.startsWith("A"))
        {
            Admin admin = loginService.selectAdmin(staffId);
            System.out.println("登录密码:" + password);
            if (null == admin)
            {
                parameter.put("status", "null");
                parameter.put("msg", "用户登录失败,无此用户");
                System.out.println("用户登录失败,无此用户");
            }
            else if (!Objects.equals(admin.getAdminPassword(), password))
            {
                System.out.println("密码:" + admin.getAdminPassword());
                parameter.put("status", "fail");
                parameter.put("msg", "用户登录失败,密码错误");
                System.out.println("用户登录失败,密码错误");
            }
            else
            {
                request.getSession().setAttribute("adminInfo", admin);
                parameter.put("status", "ok1");
                parameter.put("msg", "用户登录成功");
                parameter.put("data", admin.getAdminId());
                String token = JwtUtils.getToken(admin.getAdminId());
                parameter.put("token", token);
                System.out.println("用户登录成功");
            }
        }//if (staffId.startsWith("P"))

        //D开头：医生
        else if (staffId.startsWith("D"))
        {
            Doctor doctor = loginService.selectDoctor(staffId);
            System.out.println("登录密码:" + password);
            if (null == doctor)
            {
                parameter.put("status", "null");
                parameter.put("msg", "用户登录失败,无此用户");
                System.out.println("用户登录失败,无此用户");
            }
            else if (!Objects.equals(doctor.getDoctorPassword(), password))
            {
                System.out.println("密码:" + doctor.getDoctorPassword());
                parameter.put("status", "fail");
                parameter.put("msg", "用户登录失败,密码错误");
                System.out.println("用户登录失败,密码错误");
            }
            else
            {
                request.getSession().setAttribute("doctorInfo", doctor);
                parameter.put("status", "ok2");
                parameter.put("msg", "用户登录成功");
                parameter.put("data", doctor.getDoctorId());
                String token = JwtUtils.getToken(doctor.getDoctorId());
                parameter.put("token", token);
                System.out.println("用户登录成功");
            }
        }//else if (staffId.startsWith("D"))

        else
        {
            parameter.put("status", "fail");
            parameter.put("msg", "用户登录失败，请检查工号是否正确");
            System.out.println("用户登录失败，请检查工号是否正确");
        }//else

        return JSON.toJSONString(parameter);
    }

    @RequestMapping("/patient_token")
    @ResponseBody
    public String decodePatientToken(HttpServletRequest request, HttpServletResponse response)
    {
        Map<String, String> parameter = new HashMap<>();

        String token = request.getParameter("token");
        System.out.println(token);

        String userIdentity = JwtUtils.getClaims(token).getSubject();

        Patient patient = loginService.selectPatient(userIdentity);

        if (patient != null)
        {
            request.getSession().setAttribute("patientInfo", patient);
            parameter.put("status", "ok");
            parameter.put("msg", "用户登录成功");
            parameter.put("data", patient.getPatientIdentity());
            System.out.println("用户登录成功");
        }
        else
        {
            parameter.put("status", "fail");
            parameter.put("msg", "token解析失败");
        }

        parameter.put("status", "fail");
        return JSON.toJSONString(parameter);
    }

    @RequestMapping("/admin_token")
    @ResponseBody
    public String decodeAdminToken(HttpServletRequest request, HttpServletResponse response)
    {
        Map<String, String> parameter = new HashMap<>();

        String token = request.getParameter("token");
        System.out.println(token);

        String userIdentity = JwtUtils.getClaims(token).getSubject();

        Admin admin = loginService.selectAdmin(userIdentity);

        if (admin != null)
        {
            request.getSession().setAttribute("adminInfo", admin);
            parameter.put("status", "ok1");
            parameter.put("msg", "用户登录成功");
            parameter.put("data", admin.getAdminId());
            System.out.println("用户登录成功");
        }
        else
        {
            parameter.put("status", "fail");
            parameter.put("msg", "token解析失败");
        }


        return JSON.toJSONString(parameter);
    }

    @RequestMapping("/doctor_token")
    @ResponseBody
    public String decodeDoctorToken(HttpServletRequest request, HttpServletResponse response)
    {
        Map<String, String> parameter = new HashMap<>();

        String token = request.getParameter("token");
        System.out.println(token);

        String userIdentity = JwtUtils.getClaims(token).getSubject();

        Doctor doctor = loginService.selectDoctor(userIdentity);

        if (doctor != null)
        {
            request.getSession().setAttribute("doctorInfo", doctor);
            parameter.put("status", "ok2");
            parameter.put("msg", "用户登录成功");
            parameter.put("data", doctor.getDoctorId());
            System.out.println("用户登录成功");
        }
        else
        {
            parameter.put("status", "fail");
            parameter.put("msg", "token解析失败");
        }
        return JSON.toJSONString(parameter);
    }
}