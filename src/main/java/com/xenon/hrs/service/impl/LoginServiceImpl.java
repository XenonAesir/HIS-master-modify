package com.xenon.hrs.service.impl;

import com.xenon.hrs.generate.DoctorDao;
import com.xenon.hrs.generate.PatientDao;
import com.xenon.hrs.models.Doctor;
import com.xenon.hrs.models.Patient;
import com.xenon.hrs.service.LoginService;
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
