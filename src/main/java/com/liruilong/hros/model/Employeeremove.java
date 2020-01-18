package com.liruilong.hros.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Employeeremove {
    private Integer id;

    private Integer eid;

    private Integer afterdepid;

    private Integer afterjobid;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8" )
    private Date removedate;

    private String reason;

    private String remark;

    private Department department;
    private JobLevel jobLevel;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public JobLevel getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(JobLevel jobLevel) {
        this.jobLevel = jobLevel;
    }

    public Employeeremove() {
    }

    public Employeeremove(Integer eid, Integer afterdepid, Integer afterjobid, Date removedate, String reason) {
        this.eid = eid;
        this.afterdepid = afterdepid;
        this.afterjobid = afterjobid;
        this.removedate = removedate;
        this.reason = reason;
        this.remark = remark;
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

    public Integer getAfterdepid() {
        return afterdepid;
    }

    public void setAfterdepid(Integer afterdepid) {
        this.afterdepid = afterdepid;
    }

    public Integer getAfterjobid() {
        return afterjobid;
    }

    public void setAfterjobid(Integer afterjobid) {
        this.afterjobid = afterjobid;
    }

    public Date getRemovedate() {
        return removedate;
    }

    public void setRemovedate(Date removedate) {
        this.removedate = removedate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}