package com.xenon.hrs.generate;

import com.xenon.hrs.models.ViolateTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ViolateTableDao {
    int deleteByPrimaryKey(Integer violateId);

    int insert(ViolateTable record);

    int insertSelective(ViolateTable record);

    ViolateTable selectByPrimaryKey(Integer violateId);

    int updateByPrimaryKeySelective(ViolateTable record);

}
