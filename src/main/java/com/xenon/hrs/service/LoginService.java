package com.xenon.hrs.service;

import com.xenon.hrs.models.Doctor;
import com.xenon.hrs.models.Patient;

public interface LoginService {
    int login(String patientIdentity,String password);
    Patient selectPatient(String patientIdentity);

    // Cashier selectCashier(String staffId);

    Doctor selectDoctor(String staffId);

    // Pharmacist selectPharmacist(String staffId);
}
