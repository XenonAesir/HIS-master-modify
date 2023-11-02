package com.example.his.generate;

import com.example.his.models.ReserveTable;
import com.example.his.DTO.ReserveHistoryDto;
import com.example.his.DTO.ReserveTableDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReserveTableDao {
    int deleteByPrimaryKey(Integer reserveId);

    int insert(ReserveTable record);

    int insertSelective(ReserveTable record);

    ReserveTable selectByPrimaryKey(Integer reserveId);

    int updateByPrimaryKeySelective(ReserveTable record);

    int updateByPrimaryKey(ReserveTable record);

    List<ReserveTable> selectViolateByPatientId(String patientId);

    List<ReserveHistoryDto> selectHistoryByPatientId(String patientIdentity);

    List<ReserveTableDto> selectInfoByPIdToday(String patientIdentity);
}

