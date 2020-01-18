package com.liruilong.hros.model;

public class LogType {
    private Integer id;

    private String logtypemsg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogtypemsg() {
        return logtypemsg;
    }

    public void setLogtypemsg(String logtypemsg) {
        this.logtypemsg = logtypemsg == null ? null : logtypemsg.trim();
    }
}