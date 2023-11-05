package com.example.his.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class RemainDoctorDto
{
    private Integer remainDoctorNumberId;

    private String departmentId;

    private String doctorId;

    private Date time;

    private Integer number;

    private String doctorName;


}
