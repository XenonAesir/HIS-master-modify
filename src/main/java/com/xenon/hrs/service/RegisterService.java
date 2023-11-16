package com.xenon.hrs.service;

import com.xenon.hrs.models.Patient;


public interface RegisterService
{
    int addPatient(Patient patient);

    int updatePatient(Patient patient);

    Patient selectPatient(String patientIdentity);

}
