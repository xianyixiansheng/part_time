package com.liyi.part_time.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (TbJob)实体类
 *
 * @author makejava
 * @since 2020-03-24 00:28:06
 */
public class TbJob implements Serializable {
    private static final long serialVersionUID = 243612155408098368L;
    
    private Integer jobId;
    
    private Integer businessId;
    
    private String jobName;
    
    private String salary;
    
    private Integer reqnum;
    
    private String contact;
    
    private String worktime;
    
    private String techrequest;
    
    private String duty;
    
    private String address;
    
    private Object postTime;
    
    private Integer postState;

    private String businessName;

    private List<TbBusiness> tbBusiness;

    private List<TbDelivery> tbDelivery;

    private List<TbResume> tbResume;

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public List<TbBusiness> getTbBusiness() {
        return tbBusiness;
    }

    public void setTbBusiness(List<TbBusiness> tbBusiness) {
        this.tbBusiness = tbBusiness;
    }

    public List<com.liyi.part_time.entity.TbDelivery> getTbDelivery() {
        return tbDelivery;
    }

    public void setTbDelivery(List<com.liyi.part_time.entity.TbDelivery> tbDelivery) {
        this.tbDelivery = tbDelivery;
    }

    public List<com.liyi.part_time.entity.TbResume> getTbResume() {
        return tbResume;
    }

    public void setTbResume(List<com.liyi.part_time.entity.TbResume> tbResume) {
        this.tbResume = tbResume;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Integer getReqnum() {
        return reqnum;
    }

    public void setReqnum(Integer reqnum) {
        this.reqnum = reqnum;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getTechrequest() {
        return techrequest;
    }

    public void setTechrequest(String techrequest) {
        this.techrequest = techrequest;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object getPostTime() {
        return postTime;
    }

    public void setPostTime(Object postTime) {
        this.postTime = postTime;
    }

    public Integer getPostState() {
        return postState;
    }

    public void setPostState(Integer postState) {
        this.postState = postState;
    }

}