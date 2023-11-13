package com.xenon.hrs.service;

import com.xenon.hrs.models.Patient;

public interface PatientService {
    public Patient selectPatient(String patientIdentity);
}
