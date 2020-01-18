package com.liruilong.hros.model;

public class RwardsAndPunishments {
    private Integer id;

    private String rpsystem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRpsystem() {
        return rpsystem;
    }

    public void setRpsystem(String rpsystem) {
        this.rpsystem = rpsystem == null ? null : rpsystem.trim();
    }
}