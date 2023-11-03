package com.example.his.service.impl;

import com.example.his.generate.PatientDao;
import com.example.his.models.Patient;
import com.example.his.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService
{
    @Autowired
    private PatientDao patientDao;

    //增删改查
    public Patient selectPatient(String patientIdentity){return patientDao.selectByPrimaryKey(patientIdentity);};

}
