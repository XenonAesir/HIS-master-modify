package com.xenon.hrs.Interceptor;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class RemeberLoginIntercepter implements HandlerInterceptor {

//    @Autowired
//    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object patientSession = session.getAttribute("patientInfo");//查找患者session
        Object adminSession = session.getAttribute("adminInfo");//查找员工session
        Object doctorSession = session.getAttribute("doctorInfo");//查找员工session


        // if(null==patientSession && null==adminSession && null==doctorSession){
        //     response.sendRedirect(request.getContextPath()+"/login.html");
        //     return false;
        // }
        return true;
    }
}