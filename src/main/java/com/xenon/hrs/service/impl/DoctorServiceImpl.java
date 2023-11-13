package com.xenon.hrs.service.impl;


import com.xenon.hrs.generate.DoctorDao;
import com.xenon.hrs.models.Doctor;
import com.xenon.hrs.service.DoctorService;
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
