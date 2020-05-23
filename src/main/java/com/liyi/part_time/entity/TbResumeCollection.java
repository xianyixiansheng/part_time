package com.liyi.part_time.entity;

import java.io.Serializable;

/**
 * (TbResumeCollection)实体类
 *
 * @author makejava
 * @since 2020-03-24 00:28:08
 */
public class TbResumeCollection implements Serializable {
    private static final long serialVersionUID = -33046103786846117L;
    
    private Integer collectionId;
    
    private Integer resumeId;

    private Integer businessid;

    private Integer state;

    private Object updatetime;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Object getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Object updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

}