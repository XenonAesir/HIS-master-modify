package com.xenon.hrs.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ReserveHistoryDto
{
    private int reserveId;

    private String reserveType;

    private String departmentName;

    private String doctorName;

    private Date reserveTime;

    private String reserveState;

}
