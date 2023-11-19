package com.xenon.hrs.service.impl;

import com.xenon.hrs.generate.VacateDao;
import com.xenon.hrs.models.Vacate;
import com.xenon.hrs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    VacateDao vacateDao;

    @Override
    public List<Vacate> getVacate(String adminId)
    {
        return vacateDao.selectByAdminId(adminId);
    }

    @Override
    public int updateVacate(Vacate vacate)
    {
        return vacateDao.updateByPrimaryKey(vacate);
    }
}
