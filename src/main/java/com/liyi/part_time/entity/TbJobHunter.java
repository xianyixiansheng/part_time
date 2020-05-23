package com.liyi.part_time.entity;

import java.io.Serializable;

/**
 * (TbJobHunter)实体类
 *
 * @author makejava
 * @since 2020-03-24 00:28:09
 */
public class TbJobHunter implements Serializable {
    private static final long serialVersionUID = -63784406211073527L;
    
    private Integer jobHunterId;
    
    private String wxCode;
    
    private String wxName;

    private String img;

    private String phone;

    private String sex;

    private Object createTime;
    
    private Integer state;



    public Integer getJobHunterId() {
        return jobHunterId;
    }

    public void setJobHunterId(Integer jobHunterId) {
        this.jobHunterId = jobHunterId;
    }

    public String getWxCode() {
        return wxCode;
    }

    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}