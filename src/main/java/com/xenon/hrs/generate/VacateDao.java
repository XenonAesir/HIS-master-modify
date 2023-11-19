package com.xenon.hrs.generate;

import com.xenon.hrs.models.Vacate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VacateDao
{
    int deleteByPrimaryKey(Integer vacateId);

    int insert(Vacate vacate);

    Vacate selectByPrimaryKey(Integer vacateId);

    List<Vacate> selectByDoctorId(String doctorId);

    List<Vacate> selectByAdminId(String adminId);

    int updateByPrimaryKey(Vacate vacate);
}
