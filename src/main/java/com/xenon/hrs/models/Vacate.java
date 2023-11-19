package com.xenon.hrs.models;

import lombok.Data;

import java.io.Serializable;

import java.util.Date;

/**
* 
* @TableName vacates
*/
@Data
public class Vacate implements Serializable {

    /**
    * 请假ID
    */
    private Integer vacateId;
    /**
    * 医生ID
    */
    private String doctorId;
    /**
    * 请假描述
    */
    private String description;
    /**
    * 申请日期
    */
    private Date applyDate;
    /**
    * 请假日期
    */
    private Date vacateDate;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 管理员ID
    */
    private String adminId;
    /**
    * 审批日期
    */
    private Date adminDate;
    /**
     * 审批意见
     */
    private String adminOpinion;

}
