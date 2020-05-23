package com.liyi.part_time.vo;

import java.io.Serializable;
import java.util.Date;

public class FeedBackVO implements Serializable {

    private Integer feedbackId;

    private Integer hunterId;

    private String realName;

    private Integer businessId;

    private String businessName;

    private Integer jobId;

    private String jobName;

    private String email;

    private String evaluation;

    private Integer isassrest;

    private Object createTime;

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Integer getHunterId() {
        return hunterId;
    }

    public void setHunterId(Integer hunterId) {
        this.hunterId = hunterId;
    }

    public String getName() {
        return realName;
    }

    public void setName(String realName) {
        this.realName = realName;
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

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

}
