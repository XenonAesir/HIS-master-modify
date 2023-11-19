package com.xenon.hrs.generate;

import com.xenon.hrs.models.Vacate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VacateDao
{
    int deleteByPrimaryKey(Integer vacateId);

    int insert(Vacate vacate);

    Vacate selectByPrimaryKey(Integer vacateId);

    int updateByPrimaryKey(Vacate vacate);
}
