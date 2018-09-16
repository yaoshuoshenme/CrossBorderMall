package com.edu.pojo;


import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Integer gid;

    private String gname;

    private BigDecimal gprice;

    private Integer gtid;

    private String gpic;

    private String gpubdate;

    private String gdowdate;

    private Date gcreatedate;

    private Integer gstar;

    private String ginfo;

    private String bid;

    private Integer gflag;

    private String gtname;

    public String getGtname() {
        return gtname;
    }

    public void setGtname(String gtname) {
        this.gtname = gtname;
    }

    public String getGinfo() {
        return ginfo;
    }

    public void setGinfo(String ginfo) {
        this.ginfo = ginfo;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public BigDecimal getGprice() {
        return gprice;
    }

    public void setGprice(BigDecimal gprice) {
        this.gprice = gprice;
    }

    public Integer getGtid() {
        return gtid;
    }

    public void setGtid(Integer gtid) {
        this.gtid = gtid;
    }

    public String getGpic() {
        return gpic;
    }

    public void setGpic(String gpic) {
        this.gpic = gpic == null ? null : gpic.trim();
    }

    public String getGpubdate() {
        return gpubdate;
    }

    public void setGpubdate(String gpubdate) {
        this.gpubdate = gpubdate;
    }

    public String getGdowdate() {
        return gdowdate;
    }

    public void setGdowdate(String gdowdate) {
        this.gdowdate = gdowdate;
    }

    public Date getGcreatedate() {
        return gcreatedate;
    }

    public void setGcreatedate(Date gcreatedate) {
        this.gcreatedate = gcreatedate;
    }

    public Integer getGstar() {
        return gstar;
    }

    public void setGstar(Integer gstar) {
        this.gstar = gstar;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    public Integer getGflag() {
        return gflag;
    }

    public void setGflag(Integer gflag) {
        this.gflag = gflag;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", gtid=" + gtid +
                ", gpic='" + gpic + '\'' +
                ", gpubdate=" + gpubdate +
                ", gdowdate=" + gdowdate +
                ", gcreatedate=" + gcreatedate +
                ", gstar=" + gstar +
                ", ginfo='" + ginfo + '\'' +
                ", bid='" + bid + '\'' +
                ", gflag=" + gflag +
                '}';
    }
}