package com.liruilong.hros.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RwardsPunishments {
    private Integer id;

    private Integer rpsystemId;

    private String rpmsg;

    private Integer rpiont;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone ="GMT+8" )
    private Date createrp;

    private RwardsAndPunishments rwardsAndPunishments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRpsystemId() {
        return rpsystemId;
    }

    public void setRpsystemId(Integer rpsystemId) {
        this.rpsystemId = rpsystemId;
    }

    public String getRpmsg() {
        return rpmsg;
    }

    public void setRpmsg(String rpmsg) {
        this.rpmsg = rpmsg == null ? null : rpmsg.trim();
    }

    public Integer getRpiont() {
        return rpiont;
    }

    public void setRpiont(Integer rpiont) {
        this.rpiont = rpiont;
    }

    public Date getCreaterp() {
        return createrp;
    }

    public void setCreaterp(Date createrp) {
        this.createrp = createrp;
    }

    public RwardsAndPunishments getRwardsAndPunishments() {
        return rwardsAndPunishments;
    }

    public void setRwardsAndPunishments(RwardsAndPunishments rwardsAndPunishments) {
        this.rwardsAndPunishments = rwardsAndPunishments;
    }
}