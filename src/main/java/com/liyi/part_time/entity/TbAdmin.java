package com.liyi.part_time.entity;

import java.io.Serializable;

/**
 * (TbAdmin)实体类
 *
 * @author makejava
 * @since 2020-03-24 00:25:50
 */
public class TbAdmin implements Serializable {
    private static final long serialVersionUID = -96878432280145220L;
    
    private Integer adminId;

    private String adminName;
    
    private String adminPsw;
    
    private Object adminImg;

    private String adminSex;

    private String phone;

    private Object entry_time;

    private Integer state;

    public String getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPsw() {
        return adminPsw;
    }

    public void setAdminPsw(String adminPsw) {
        this.adminPsw = adminPsw;
    }

    public Object getAdminImg() {
        return adminImg;
    }

    public void setAdminImg(Object adminImg) {
        this.adminImg = adminImg;
    }

    public Object getEntry_time() { return entry_time; }

    public void setEntry_time(Object entry_time) { this.entry_time = entry_time; }

    public Integer getState() { return state; }

    public void setState(Integer state) { this.state = state; }

    @Override
    public String toString() {
        return "TbAdmin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPsw='" + adminPsw + '\'' +
                ", adminImg=" + adminImg +
                ", adminSex='" + adminSex + '\'' +
                ", phone='" + phone + '\'' +
                ", entry_time=" + entry_time +
                ", state=" + state +
                '}';
    }

}