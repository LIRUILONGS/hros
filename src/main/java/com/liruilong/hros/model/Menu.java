package com.liruilong.hros.model;

import java.util.List;

public class Menu {
    private Integer id;

    private String url;

    private String path;

    private String component;

    private String name;

    private String iconcls;

    private  Meta meta;

    private Integer parentid;

    private Boolean enabled;

    private List<Menu> children;

    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls == null ? null : iconcls.trim();
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", name='" + name + '\'' +
                ", iconcls='" + iconcls + '\'' +
                ", meta=" + meta +
                ", parentid=" + parentid +
                ", enabled=" + enabled +
                ", children=" + children +
                ", roles=" + roles +
                '}';
    }
}