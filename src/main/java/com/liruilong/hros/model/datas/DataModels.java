package com.liruilong.hros.model.datas;

/**
 * @Description :

 * @Date: 2020/1/7 11:41
 */
public class DataModels extends DataModel {
    private Integer workage;

    public DataModels(Integer sum, String name ,Integer workage) {
        super(name, sum);
        this.workage = workage;
    }

    public DataModels() {
        super();
        this.workage = 0;
    }

    public Integer getWorkage() {
        return workage;
    }

    public void setWorkage(Integer workage) {
        this.workage = workage;
    }
}
