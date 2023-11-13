package com.xenon.hrs.service.impl;

import com.xenon.hrs.generate.PatientDao;
import com.xenon.hrs.models.Patient;
import com.xenon.hrs.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService
{
    @Autowired
    PatientDao patientDao;

    //患者注册
    @Override
    public int addPatient(Patient patient) {
        return patientDao.insertSelective(patient);
    }

    @Override
    public Patient selectPatient(String patientIdentity) {
        return patientDao.selectByPrimaryKey(patientIdentity);
    }

}
