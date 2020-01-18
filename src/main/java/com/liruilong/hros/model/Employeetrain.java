package com.liruilong.hros.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Employeetrain {
    private Integer id;

    private Integer eid;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8" )
    private Date trainstartdate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8" )
    private Date trainfinishdate;

    private String traincontent;

    private Byte trainstatus;

    private String remark;

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

    public Date getTrainstartdate() {
        return trainstartdate;
    }

    public void setTrainstartdate(Date trainstartdate) {
        this.trainstartdate = trainstartdate;
    }

    public Date getTrainfinishdate() {
        return trainfinishdate;
    }

    public void setTrainfinishdate(Date trainfinishdate) {
        this.trainfinishdate = trainfinishdate;
    }

    public String getTraincontent() {
        return traincontent;
    }

    public void setTraincontent(String traincontent) {
        this.traincontent = traincontent == null ? null : traincontent.trim();
    }

    public Byte getTrainstatus() {
        return trainstatus;
    }

    public void setTrainstatus(Byte trainstatus) {
        this.trainstatus = trainstatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "Employeetrain{" +
                "id=" + id +
                ", eid=" + eid +
                ", trainstartdate=" + trainstartdate +
                ", trainfinishdate=" + trainfinishdate +
                ", traincontent='" + traincontent + '\'' +
                ", trainstatus=" + trainstatus +
                ", remark='" + remark + '\'' +
                '}';
    }
}