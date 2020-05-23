package com.liyi.part_time.vo;

import java.io.Serializable;

public class DeliveryVO implements Serializable {

    private Integer delId;

    private String endState;

    public Integer getDelId() {
        return delId;
    }

    public void setDelId(Integer delId) {
        this.delId = delId;
    }

    public String getEndState() {
        return endState;
    }

    public void setEndState(String endState) {
        this.endState = endState;
    }
}
