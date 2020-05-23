package com.liyi.part_time.vo;

import com.liyi.part_time.entity.TbBusiness;
import com.liyi.part_time.entity.TbDelivery;
import com.liyi.part_time.entity.TbResume;

import java.io.Serializable;
import java.util.List;

public class JobVO  implements Serializable {
    private Integer jobId;

    private Integer businessId;

    private String businessName;

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


    private Integer postNum;


    private Integer abletime;

    private List<TbBusiness> tbBusiness;

    public Integer getAbletime() {
        return abletime;
    }

    public void setAbletime(Integer abletime) {
        this.abletime = abletime;
    }

    public List<TbBusiness> getTbBusiness() {
        return tbBusiness;
    }

    public void setTbBusiness(List<TbBusiness> tbBusiness) {
        this.tbBusiness = tbBusiness;
    }

    public List<TbDelivery> getTbDelivery() {
        return tbDelivery;
    }

    public void setTbDelivery(List<TbDelivery> tbDelivery) {
        this.tbDelivery = tbDelivery;
    }

    public List<TbResume> getTbResume() {
        return tbResume;
    }

    public void setTbResume(List<TbResume> tbResume) {
        this.tbResume = tbResume;
    }

    private List<TbDelivery> tbDelivery;

    private List<TbResume> tbResume;

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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
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

    public Integer getPostNum() {
        return postNum;
    }

    public void setPostNum(Integer postNum) {
        this.postNum = postNum;
    }

}
