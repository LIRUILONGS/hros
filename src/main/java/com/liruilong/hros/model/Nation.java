package com.liruilong.hros.model;

import java.util.Objects;

public class Nation {
    private Integer id;

    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nation nation = (Nation) o;
        return name.equals(nation.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Nation(){}
    public Nation(String name){
        this.name = name;
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
}