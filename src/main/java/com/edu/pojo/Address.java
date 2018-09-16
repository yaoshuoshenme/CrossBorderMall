package com.edu.pojo;

import java.util.Date;

public class Address {
    private Integer aid;

    private String aname;

    private String aphone;

    private Integer pid;

    private String pname;

    private Integer cityid;

    private String cityname;

    private Integer countryid;

    private String countryname;

    private Integer aord;

    private Date acreatetime;

    private String adetail;

    private Integer uid;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone == null ? null : aphone.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getCountryid() {
        return countryid;
    }

    public void setCountryid(Integer countryid) {
        this.countryid = countryid;
    }

    public Integer getAord() {
        return aord;
    }

    public void setAord(Integer aord) {
        this.aord = aord;
    }

    public Date getAcreatetime() {
        return acreatetime;
    }

    public void setAcreatetime(Date acreatetime) {
        this.acreatetime = acreatetime;
    }

    public String getAdetail() {
        return adetail;
    }

    public void setAdetail(String adetail) {
        this.adetail = adetail == null ? null : adetail.trim();
    }

    @Override
    public String toString() {
        return  " 收件人：" + aname +  " 手机号：" + aphone +"  "+pname + "省"+cityname+"市"+countryname+"县"+adetail;
    }
}