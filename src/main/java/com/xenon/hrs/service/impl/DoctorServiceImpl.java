package com.xenon.hrs.service.impl;


import com.xenon.hrs.DTO.ReserveInfoDto;
import com.xenon.hrs.DTO.ReserveTableDto;
import com.xenon.hrs.generate.DoctorDao;
import com.xenon.hrs.generate.ReserveTableDao;
import com.xenon.hrs.generate.VacateDao;
import com.xenon.hrs.models.Doctor;
import com.xenon.hrs.models.ReserveTable;
import com.xenon.hrs.models.Vacate;
import com.xenon.hrs.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService
{
    @Autowired
    DoctorDao doctorDao;
    @Autowired
    ReserveTableDao reserveTableDao;
    @Autowired
    VacateDao vacateDao;

    //
    public Doctor findById(String doctorId)
    {
        return doctorDao.selectByPrimaryKey(doctorId);
    }

    @Override
    public List<ReserveInfoDto> getThisWeekReserve(String doctorId)
    {
        return reserveTableDao.selectInfoByDoctorIdThisWeek(doctorId);
    }

    @Override
    public int applyVacate(Vacate vacate)
    {
        return vacateDao.insert(vacate);
    }
}
