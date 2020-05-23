package com.liyi.part_time.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (TbBusiness)实体类
 *
 * @author makejava
 * @since 2020-03-24 00:28:06
 */
public class TbBusiness implements Serializable {
    private static final long serialVersionUID = 306402938462084669L;
    
    private Integer businessId;
    
    private String businessUsername;
    
    private String businessPsw;

    private String businessWxcode;

    private String businessWxName;

    private String businessImg;

    private String brief;
    
    private String businessName;

    private String capital;

    private String creditCode;
    
    private String businessTrade;
    
    private String address;

    private String companyrange;

    private Object foundtime;
    
    private String contact;
    
    private String email;
    
    private String telephone;
    
    private String license;
    
    private Integer state;
    
    private Integer forbidden;

    public List<TbJob> getTbJob() {
        return tbJob;
    }

    public void setTbJob(List<TbJob> tbJob) {
        this.tbJob = tbJob;
    }

    private List<TbJob> tbJob;

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessUsername() {
        return businessUsername;
    }

    public void setBusinessUsername(String businessUsername) {
        this.businessUsername = businessUsername;
    }

    public String getBusinessPsw() {
        return businessPsw;
    }

    public void setBusinessPsw(String businessPsw) {
        this.businessPsw = businessPsw;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessTrade() {
        return businessTrade;
    }

    public void setBusinessTrade(String businessTrade) {
        this.businessTrade = businessTrade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getForbidden() {
        return forbidden;
    }

    public void setForbidden(Integer forbidden) {
        this.forbidden = forbidden;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getRange() {
        return companyrange;
    }

    public void setRange(String companyrange) {
        this.companyrange = companyrange;
    }

    public Object getFoundtime() {
        return foundtime;
    }

    public void setFoundtime(Object foundtime) {
        this.foundtime = foundtime;
    }

    public String getBusinessWxcode() {
        return businessWxcode;
    }

    public void setBusinessWxcode(String businessWxcode) {
        this.businessWxcode = businessWxcode;
    }

    public String getBusinessWxName() {
        return businessWxName;
    }

    public void setBusinessWxName(String businessWxName) {
        this.businessWxName = businessWxName;
    }

    public String getBusinessImg() {
        return businessImg;
    }

    public void setBusinessImg(String businessImg) {
        this.businessImg = businessImg;
    }


}