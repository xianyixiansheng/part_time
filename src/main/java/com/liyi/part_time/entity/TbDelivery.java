package com.liyi.part_time.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (TbDelivery)实体类
 *
 * @author makejava
 * @since 2020-03-24 00:28:07
 */
public class TbDelivery implements Serializable {
    private static final long serialVersionUID = -81482070797252176L;
    
    private Integer delId;
    
    private Integer resumeId;
    
    private Integer businessId;
    
    private Integer jobId;
    
    private Integer state;
    
    private Object deliveryTime;

    private String remark;
    
    private Object checkTime;
    
    private Object inviteTime;
    
    private Object interviewTime;
    
    private String interviewContact;
    
    private String interviewPhone;
    
    private String address;

    private TbResume tbResume;

    private TbBusiness tbBusiness;

    private TbJob tbJob;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Object getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Object deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Object getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Object checkTime) {
        this.checkTime = checkTime;
    }

    public Object getInviteTime() {
        return inviteTime;
    }

    public void setInviteTime(Object inviteTime) {
        this.inviteTime = inviteTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public TbBusiness getTbBusiness() {
        return tbBusiness;
    }

    public void setTbBusiness(TbBusiness tbBusiness) {
        this.tbBusiness = tbBusiness;
    }

    public TbJob getTbJob() {
        return tbJob;
    }

    public void setTbJob(TbJob tbJob) {
        this.tbJob = tbJob;
    }

    public TbResume getTbResume() {
        return tbResume;
    }

    public void setTbResume(TbResume tbResume) {
        this.tbResume = tbResume;
    }

    public Integer getDelId() {
        return delId;
    }

    public void setDelId(Integer delId) {
        this.delId = delId;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getState2() {
        return remark;
    }

    public void setState2(String remark) {
        this.remark = remark;
    }

    public Object getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Object interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getInterviewContact() {
        return interviewContact;
    }

    public void setInterviewContact(String interviewContact) {
        this.interviewContact = interviewContact;
    }

    public String getInterviewPhone() {
        return interviewPhone;
    }

    public void setInterviewPhone(String interviewPhone) {
        this.interviewPhone = interviewPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}