package com.liruilong.hros.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Employeeec {
    private Integer id;

    private Integer eid;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8" )
    private Date ecdate;

    private String ecreason;

    private Integer ecpoint;

    private Integer ectype;

    private String remark;

    private RwardsPunishments rwardsPunishments;



    public RwardsPunishments getRwardsPunishments() {
        return rwardsPunishments;
    }

    public void setRwardsPunishments(RwardsPunishments rwardsPunishments) {
        this.rwardsPunishments = rwardsPunishments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getEcdate() {
        return ecdate;
    }

    public void setEcdate(Date ecdate) {
        this.ecdate = ecdate;
    }

    public String getEcreason() {
        return ecreason;
    }

    public void setEcreason(String ecreason) {
        this.ecreason = ecreason == null ? null : ecreason.trim();
    }

    public Integer getEcpoint() {
        return ecpoint;
    }

    public void setEcpoint(Integer ecpoint) {
        this.ecpoint = ecpoint;
    }

    public Integer getEctype() {
        return ectype;
    }

    public void setEctype(Integer ectype) {
        this.ectype = ectype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {

        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "Employeeec{" +
                "id=" + id +
                ", eid=" + eid +
                ", ecdate=" + ecdate +
                ", ecreason='" + ecreason + '\'' +
                ", ecpoint=" + ecpoint +
                ", ectype=" + ectype +
                ", remark='" + remark + '\'' +
                '}';
    }
}