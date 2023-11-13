package com.xenon.hrs.service.impl;

import com.xenon.hrs.generate.PatientDao;
import com.xenon.hrs.models.Patient;
import com.xenon.hrs.service.PatientService;
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
