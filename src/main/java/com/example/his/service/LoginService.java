package com.example.his.service;

import com.example.his.models.Doctor;
import com.example.his.models.Patient;

public interface LoginService {
    int login(String patientIdentity,String password);
    Patient selectPatient(String patientIdentity);

    // Cashier selectCashier(String staffId);

    Doctor selectDoctor(String staffId);

    // Pharmacist selectPharmacist(String staffId);
}
