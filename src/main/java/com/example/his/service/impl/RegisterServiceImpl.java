package com.example.his.service.impl;

import com.example.his.generate.PatientDao;
import com.example.his.generate.RegisterTableDao;
import com.example.his.models.Patient;
import com.example.his.models.RegisterTable;
import com.example.his.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService
{
    @Autowired
    PatientDao patientDao;
    @Autowired
    private RegisterTableDao registerTableDao;

    //患者注册
    @Override
    public int addPatient(Patient patient) {
        return patientDao.insertSelective(patient);
    }



    //取号单
    @Override
    public Patient selectPatient(String patientIdentity) {
        return patientDao.selectByPrimaryKey(patientIdentity);
    }

    @Override
    public RegisterTable findById(Integer registerId) {
        return registerTableDao.selectByPrimaryKey(registerId);
    }
}