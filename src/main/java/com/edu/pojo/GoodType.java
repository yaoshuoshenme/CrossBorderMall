package com.edu.pojo;

public class GoodType {
    private Integer gtid;

    private String gtname;

    private Integer gtlevel;

    private Integer gtparentid;

    private String gtparentname;

    private Integer gtflag;

    public String getGtparentname() {
        return gtparentname;
    }

    public void setGtparentname(String gtparentname) {
        this.gtparentname = gtparentname;
    }

    public Integer getGtid() {
        return gtid;
    }

    public void setGtid(Integer gtid) {
        this.gtid = gtid;
    }

    public String getGtname() {
        return gtname;
    }

    public void setGtname(String gtname) {
        this.gtname = gtname == null ? null : gtname.trim();
    }

    public Integer getGtlevel() {
        return gtlevel;
    }

    public void setGtlevel(Integer gtlevel) {
        this.gtlevel = gtlevel;
    }

    public Integer getGtparentid() {
        return gtparentid;
    }

    public void setGtparentid(Integer gtparentid) {
        this.gtparentid = gtparentid;
    }

    public Integer getGtflag() {
        return gtflag;
    }

    public void setGtflag(Integer gtflag) {
        this.gtflag = gtflag;
    }
}