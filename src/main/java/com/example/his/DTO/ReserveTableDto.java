package com.example.his.DTO;

import lombok.Data;

@Data
public class ReserveTableDto
{
    //患者姓名、患者身份证号、预约种类(1科室，0专家)、预约科室id、预约医生姓名、时间，状态(,0待确认,1已完成,-1已取消)
    int reserveId;

    String patientIdentity;

    String patientName;

    int reserveType;

    String departmentId;

    String doctorName;

    String reserveTime;

    int reserveState;

}
