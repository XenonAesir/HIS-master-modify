package com.example.his.generate;

import com.example.his.models.RemainDeptNumber;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RemainDeptNumberDao {
    List<RemainDeptNumber> getAll();

    int deleteByPrimaryKey(Integer remainDeptNumderId);

    int insert(RemainDeptNumber record);

    int insertSelective(RemainDeptNumber record);

    RemainDeptNumber selectByPrimaryKey(Integer remainDeptNumderId);

    int updateByPrimaryKeySelective(RemainDeptNumber record);

    int updateByPrimaryKey(RemainDeptNumber record);

    List<RemainDeptNumber> selectByDeptId(@Param("DeptId") String DeptId);

    List<RemainDeptNumber> getAllToday();
}