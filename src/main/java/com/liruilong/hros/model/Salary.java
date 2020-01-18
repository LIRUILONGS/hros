package com.liruilong.hros.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Salary {
    private Integer id;

    private Integer basicsalary;

    private Integer bonus;

    private Integer lunchsalary;

    private Integer trafficsalary;

    private Integer allsalary;

    private Integer pensionbase;

    private Float pensionper;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdate;

    private Integer medicalbase;

    private Float medicalper;

    private Integer accumulationfundbase;

    private Float accumulationfundper;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(Integer basicsalary) {
        this.basicsalary = basicsalary;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getLunchsalary() {
        return lunchsalary;
    }

    public void setLunchsalary(Integer lunchsalary) {
        this.lunchsalary = lunchsalary;
    }

    public Integer getTrafficsalary() {
        return trafficsalary;
    }

    public void setTrafficsalary(Integer trafficsalary) {
        this.trafficsalary = trafficsalary;
    }

    public Integer getAllsalary() {
        return allsalary;
    }

    public void setAllsalary(Integer allsalary) {
        this.allsalary = allsalary;
    }

    public Integer getPensionbase() {
        return pensionbase;
    }

    public void setPensionbase(Integer pensionbase) {
        this.pensionbase = pensionbase;
    }

    public Float getPensionper() {
        return pensionper;
    }

    public void setPensionper(Float pensionper) {
        this.pensionper = pensionper;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getMedicalbase() {
        return medicalbase;
    }

    public void setMedicalbase(Integer medicalbase) {
        this.medicalbase = medicalbase;
    }

    public Float getMedicalper() {
        return medicalper;
    }

    public void setMedicalper(Float medicalper) {
        this.medicalper = medicalper;
    }

    public Integer getAccumulationfundbase() {
        return accumulationfundbase;
    }

    public void setAccumulationfundbase(Integer accumulationfundbase) {
        this.accumulationfundbase = accumulationfundbase;
    }

    public Float getAccumulationfundper() {
        return accumulationfundper;
    }

    public void setAccumulationfundper(Float accumulationfundper) {
        this.accumulationfundper = accumulationfundper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}