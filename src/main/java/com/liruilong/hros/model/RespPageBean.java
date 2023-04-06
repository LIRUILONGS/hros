package com.liruilong.hros.model;

import java.util.List;

/**
 * @Description : 分页

 * @Date: 2019/12/31 11:20
 */
public class RespPageBean {

    /*总记录树*/
    private Long total;
    /*分页数据*/
    private List<?> data;

    public RespPageBean() {
    }

    public RespPageBean(Long total, List<?> data) {
        this.total = total;
        this.data = data;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
