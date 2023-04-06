package com.liruilong.hros.model;

/**
 * @Description :返回信息的实体类

 * @Date: 2019/12/19 17:34
 */
public class RespBean {
    private Integer status;
    private String msg;
    private Object obj;

    public static RespBean ok(String msg){
        return new RespBean(200, msg, null);
    }
    public static RespBean ok(String msg, Object obj){
        return new RespBean(200, msg, obj);
    }
    public static RespBean error(String msg){
        return new RespBean(500, msg, null);
    }
    public static RespBean error(String msg, Object obj){
        return new RespBean(200, msg, obj);
    }

    private RespBean() {
    }

    private RespBean(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public static RespBean build() {
        return new RespBean();
    }

    public Integer getStatus() {
        return status;
    }

    public RespBean setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public RespBean setObj(Object obj) {
        this.obj = obj;
        return this;
    }

}
