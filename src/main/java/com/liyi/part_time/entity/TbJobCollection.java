package com.liyi.part_time.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TbJobCollection)实体类
 *
 * @author makejava
 * @since 2020-03-24 00:28:05
 */
public class TbJobCollection implements Serializable {
    private static final long serialVersionUID = -43994232905578269L;

    private Integer jobCollectionId;

    private Integer jobId;

    private Integer resumeId;

    private Object ctime;

    private Integer cstate;

    public Integer getJobCollectionId() {
        return jobCollectionId;
    }

    public void setJobCollectionId(Integer jobCollectionId) {
        this.jobCollectionId = jobCollectionId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public Object getTime() {
        return ctime;
    }

    public void setTime(Object ctime) {
        this.ctime = ctime;
    }

    public Integer getCstate() {
        return cstate;
    }

    public void setCstate(Integer cstate) {
        this.cstate = cstate;
    }

}