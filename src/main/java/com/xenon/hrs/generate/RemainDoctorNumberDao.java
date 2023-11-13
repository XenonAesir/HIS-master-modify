package com.xenon.hrs.generate;

import com.xenon.hrs.models.RemainDoctorNumber;
import com.xenon.hrs.DTO.RemainDoctorDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RemainDoctorNumberDao {

     List<RemainDoctorDto> selectByDoctorId(String doctorId);

    List<RemainDoctorDto> getAllDoctorRemain();

    int insert(RemainDoctorNumber record);

    int insertSelective(RemainDoctorNumber record);

    List<RemainDoctorNumber> selectByDoctorID(String doctorId);

    void updateByPrimaryKey(RemainDoctorNumber remainDoctorNumber);

    List<RemainDoctorDto> getAllDoctorRemainToday();

    List<RemainDoctorNumber> selectByDoctorIdAndTime(String doctorId);
}
