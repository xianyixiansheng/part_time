package com.liyi.part_time.util;

import java.util.List;

//    由于layui的table 组件默认规定的数据格式为
//         {
//          "code": 0,
//          "msg": "",
//          "count": 1000,
//          "data": [{}, {}]
//        }
//    故要进行数据的封装，使用util封装好数据的Layui类对data赋值进行数据传送
public class LayuiPage<T> {
    private String code;
    private String msg;
    private Integer count;
    private List<T> data;

    public LayuiPage() {
    }

    public LayuiPage(Integer count, List<T> data) {
        this.code = "0";
        this.msg = "true";
        this.count = count;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}