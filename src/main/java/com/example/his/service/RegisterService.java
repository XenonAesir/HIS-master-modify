package com.example.his.service;

import com.example.his.models.Patient;
import com.example.his.models.RegisterTable;
import org.springframework.stereotype.Service;


public interface RegisterService {
    int addPatient(Patient patient);

    Patient selectPatient(String patientIdentity);

    RegisterTable findById(Integer registerId);
}
