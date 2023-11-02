package com.example.his.service;

import com.example.his.models.Patient;

public interface PatientService {
    public Patient selectPatient(String patientIdentity);
}
