package com.xenon.hrs.models;

import lombok.Data;

import java.io.Serializable;

/**
 * admins
 * @author 
 */
@Data
public class Admin implements Serializable {
    /**
     * 工号
     */
    private String adminId;

    /**
     * 身份证号
     */
    private String adminIdentity;

    /**
     * 密码
     */
    private String adminPassword;

    /**
     * 姓名
     */
    private String adminName;

    /**
     * 性别1男,0女
     */
    private Integer adminGender;

    /**
     * 电话
     */
    private String adminTel;

    /**
     * 家庭住址
     */
    private String adminAddress;

    private static final long serialVersionUID = 1L;

    public Admin(String adminId, String adminPassword) {
        this.adminId = adminId;
        this.adminPassword = adminPassword;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminIdentity() {
        return adminIdentity;
    }

    public void setAdminIdentity(String adminIdentity) {
        this.adminIdentity = adminIdentity;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getAdminGender() {
        return adminGender;
    }

    public void setAdminGender(Integer adminGender) {
        this.adminGender = adminGender;
    }

    public String getAdminTel() {
        return adminTel;
    }

    public void setAdminTel(String adminTel) {
        this.adminTel = adminTel;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }
}