package com.liruilong.hros.model.datas;

/**
 * @Description : 数据模型

 * @Date: 2020/1/5 15:46
 */

public class DataModel {
    private  String name;
    private Integer sum;


    public DataModel() {
        this.name = null;
        this.sum = 0;
    }

    public DataModel(String name, Integer sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
