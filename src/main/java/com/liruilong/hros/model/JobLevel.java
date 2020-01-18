package com.liruilong.hros.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class JobLevel implements Serializable {
    private Integer id;

    private String name;

    private String titlelevel;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone ="GMT+8" )
    private Date createdate;

    private Boolean enabled;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobLevel jobLevel = (JobLevel) o;
        return name.equals(jobLevel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public JobLevel(String name) {
        this.name = name;
    }

    public JobLevel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTitlelevel() {
        return titlelevel;
    }

    public void setTitlelevel(String titlelevel) {
        this.titlelevel = titlelevel == null ? null : titlelevel.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}