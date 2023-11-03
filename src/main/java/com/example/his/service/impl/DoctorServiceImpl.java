package com.example.his.service.impl;


import com.example.his.generate.DoctorDao;
import com.example.his.models.Doctor;
import com.example.his.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService
{
    @Autowired
    DoctorDao doctorDao;

    //
    public Doctor findById(String doctorId){return doctorDao.selectByPrimaryKey(doctorId);}
}
