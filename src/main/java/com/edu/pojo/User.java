package com.edu.pojo;

public class User {
    private Integer uid;

    private String uname;

    private String upassword;

    private String usex;

    private String umail;

    private String uactivation;

    private Integer uflag;

    public User(Integer uid, String uname, String upassword, String usex, String umail) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
        this.usex = usex;
        this.umail = umail;
    }

    public User() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword == null ? null : upassword.trim();
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex == null ? null : usex.trim();
    }

    public String getUmail() {
        return umail;
    }

    public void setUmail(String umail) {
        this.umail = umail == null ? null : umail.trim();
    }

    public String getUactivation() {
        return uactivation;
    }

    public void setUactivation(String uactivation) {
        this.uactivation = uactivation == null ? null : uactivation.trim();
    }

    public Integer getUflag() {
        return uflag;
    }

    public void setUflag(Integer uflag) {
        this.uflag = uflag;
    }
}