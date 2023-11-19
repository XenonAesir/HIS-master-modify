package com.xenon.hrs.service;

import com.xenon.hrs.models.Vacate;

import java.util.List;

public interface AdminService
{
    public List<Vacate> getVacate(String adminId);

    public int updateVacate(Vacate vacate);
}
