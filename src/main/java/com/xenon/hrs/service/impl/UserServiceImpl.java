package com.xenon.hrs.service.impl;

import com.xenon.hrs.generate.PatientDao;
import com.xenon.hrs.models.Patient;
import com.xenon.hrs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    PatientDao patientDao;

    //患者注册
    @Override
    public int addPatient(Patient patient)
    {
        return patientDao.insertSelective(patient);
    }

    @Override
    public int updatePatient(Patient patient)
    {
        return patientDao.updateByPrimaryKey(patient);
    }

    @Override
    public Patient selectPatient(String patientIdentity)
    {
        return patientDao.selectByPrimaryKey(patientIdentity);
    }

}
