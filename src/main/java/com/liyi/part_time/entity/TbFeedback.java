package com.liyi.part_time.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbFeedback)实体类
 *
 * @author makejava
 * @since 2020-04-08 21:29:57
 */
public class TbFeedback implements Serializable {
    private static final long serialVersionUID = 179555916851814671L;
    
    private Integer feedbackId;
    
    private String name;

    private Integer hunterId;

    private Integer businessId;

    private Integer jobId;

    private String email;

    private String evaluation;

    private Integer isassrest;

    private Date createTime;

    public Integer getHunterId() {
        return hunterId;
    }

    public void setHunterId(Integer hunterId) {
        this.hunterId = hunterId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }




    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public Integer getIsassrest() {
        return isassrest;
    }

    public void setIsassrest(Integer isassrest) {
        this.isassrest = isassrest;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}