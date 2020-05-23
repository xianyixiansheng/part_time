package com.liyi.part_time.vo;

import java.io.Serializable;

public class JobHunterVO  implements Serializable {

    private Integer jobHunterId;

    private String wxCode;

    private String wxName;

    private String img;

    private String phone;

    private Integer age;

    private String sex;

    private Object createTime;

    private Integer state;

    private String name;

    private String eduschool;

    private String edumajor;

    private String nation;

    private String eduduty;

    private String eduaward;

    private String evaluation;

    private Object updateTime;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEduduty() {
        return eduduty;
    }

    public void setEduduty(String eduduty) {
        this.eduduty = eduduty;
    }

    public String getEduaward() {
        return eduaward;
    }

    public void setEduaward(String eduaward) {
        this.eduaward = eduaward;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }



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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEduschool() {
        return eduschool;
    }

    public void setEduschool(String eduschool) {
        this.eduschool = eduschool;
    }

    public String getEdumajor() {
        return edumajor;
    }

    public void setEdumajor(String edumajor) {
        this.edumajor = edumajor;
    }
}
