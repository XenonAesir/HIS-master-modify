package com.example.his.service.impl;

import com.example.his.generate.DoctorDao;
import com.example.his.generate.PatientDao;
import com.example.his.models.Doctor;
import com.example.his.models.Patient;
import com.example.his.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService
{
    @Autowired
    PatientDao patientDao;
    @Autowired
    DoctorDao doctorDao;
    @Override
    public int login(String patientIdentity, String password) {
        return 0;
    }

    @Override
    public Patient selectPatient(String patientIdentity) {
        return patientDao.selectByPrimaryKey(patientIdentity);
    }


    @Override
    public Doctor selectDoctor(String staffId) {
        return doctorDao.selectByPrimaryKey(staffId);
    }

}
