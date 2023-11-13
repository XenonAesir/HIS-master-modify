package com.xenon.hrs.generate;

import java.util.List;

import com.xenon.hrs.models.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentDao
{

    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAll();
}