package com.liyi.part_time.entity;

import java.io.Serializable;

/**
 * (TbResume)实体类
 *
 * @author makejava
 * @since 2020-03-24 00:28:08
 */
public class TbResume implements Serializable {
    private static final long serialVersionUID = 413331200819832982L;
    
    private Integer resumeId;
    
    private Integer jobHunterId;
    
    private String name;

    private String image;
    
    private String phone;
    
    private String sex;

    private Integer age;

    private String jobCategory;

    private String residence;

    private String nation;
    
    private String eduschool;
    
    private String edumajor;
    
    private String eduduty;
    
    private String eduaward;
    
    private String evaluation;
    
    private Object updateTime;


    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public Integer getJobHunterId() {
        return jobHunterId;
    }

    public void setJobHunterId(Integer jobHunterId) {
        this.jobHunterId = jobHunterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
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

}