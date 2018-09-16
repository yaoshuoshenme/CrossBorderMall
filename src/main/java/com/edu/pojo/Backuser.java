package com.edu.pojo;

public class Backuser {
    private Integer bid;

    private String bname;

    private String bpassword;

    private String bsex;

    private Integer bflag;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public String getBpassword() {
        return bpassword;
    }

    public void setBpassword(String bpassword) {
        this.bpassword = bpassword == null ? null : bpassword.trim();
    }

    public String getBsex() {
        return bsex;
    }

    public void setBsex(String bsex) {
        this.bsex = bsex == null ? null : bsex.trim();
    }

    public Integer getBflag() {
        return bflag;
    }

    public void setBflag(Integer bflag) {
        this.bflag = bflag;
    }
}