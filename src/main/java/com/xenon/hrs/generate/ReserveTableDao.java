package com.xenon.hrs.generate;

import com.xenon.hrs.DTO.ReserveInfoDto;
import com.xenon.hrs.models.ReserveTable;
import com.xenon.hrs.DTO.ReserveHistoryDto;
import com.xenon.hrs.DTO.ReserveTableDto;
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

    List<ReserveInfoDto> selectInfoByDoctorIdThisWeek(String doctorId);
}

