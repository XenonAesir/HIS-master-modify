package com.example.his.service;

import com.example.his.models.*;
import com.example.his.DTO.RemainDoctorDto;
import com.example.his.DTO.ReserveHistoryDto;

import java.util.List;

public interface AppointmentService {
    List<RemainDeptNumber> getAllRemainDeptNumber();

    List<RemainDoctorDto> getAllDoctorRemain();
    int addReserveTable(ReserveTable reserveTable);
    int getBlackFlag(Patient patient);
    int updateRemainDeptNumber(RemainDeptNumber remainDeptNumber);
    List<RemainDeptNumber> getRemainDeptNumberByDeptId( String DeptId);

    int addRemainDeptNumber(RemainDeptNumber remainDeptNumber);
    List<Department> getAllDepartment();

    List<Doctor> getAllDoctor();

    int addremainDoctorNumber(RemainDoctorNumber remainDoctorNumber);

    List<RemainDoctorNumber> getRemainDeptNumberByDoctorId(String doctorId);

    void updateRemainDoctorNumber(RemainDoctorNumber remainDoctorNumber);

    List<ReserveHistoryDto> getReserveHistoryByPatientId(String patientIdentity);

    void updateReserveState(ReserveTable reserveTable);

    ReserveTable getRserveTabltByPk(int reserveId);

    void addViolateTable(ViolateTable violateTable);

    List<RemainDoctorDto> getAllDoctorRemainByDoctorId(String doctorId);
}
