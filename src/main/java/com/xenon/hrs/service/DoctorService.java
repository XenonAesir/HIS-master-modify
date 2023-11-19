package com.xenon.hrs.service;

import com.xenon.hrs.DTO.ReserveInfoDto;
import com.xenon.hrs.models.Doctor;
import com.xenon.hrs.models.Vacate;


import java.util.List;

public interface DoctorService
{
    public Doctor findById(String doctorId);

    public List<ReserveInfoDto> getThisWeekReserve(String doctorId);

    public int applyVacate(Vacate vacate);

    public List<Vacate> getVacate(String doctorId);
}
