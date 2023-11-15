package com.xenon.hrs.generate;

import com.xenon.hrs.models.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao
{
    int deleteByPrimaryKey(String adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}