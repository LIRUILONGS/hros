package com.liruilong.hros.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OpLog {
    private Integer id;

    private Byte logtype;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone ="GMT+8" )
    private Date adddate;

    private String operate;

    private String hrname;

    private LogType logTypss;


    public OpLog() {
    }

    public OpLog(Byte logtype, String operate, String hrname) {
        this.logtype = logtype;
        this.operate = operate;
        this.hrname = hrname;
    }

    public OpLog(Byte logtype, Date adddate, String operate, String hrname) {
        this.logtype = logtype;
        this.adddate = adddate;
        this.operate = operate;
        this.hrname = hrname;
    }

    public LogType getlogTypss() {
        return logTypss;
    }

    public void setlogTypss(LogType logTypss) {
        this.logTypss = logTypss;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getLogtype() {
        return logtype;
    }

    public void setLogtype(Byte logtype) {
        this.logtype = logtype;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }

    public String getHrname() {
        return hrname;
    }

    public void setHrname(String hrname) {
        this.hrname = hrname == null ? null : hrname.trim();
    }
}