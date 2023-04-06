package com.liruilong.hros.model.datas;

/**
 * @Description :

 * @Date: 2020/1/6 19:57
 */
public class DataModelT  extends DataModel{
    private Integer dimission;

    private Integer entrant;

    private Double aDouble;

    public DataModelT() {
        super();
        this.dimission = 0;
        this.entrant = 0;
        this.aDouble = 0d;
    }

    public DataModelT(Integer entrant, String name) {
        super(name,0);
        this.dimission = 0;
        this.entrant = entrant;
        this.aDouble = 0d;
    }

    public DataModelT(String name, Integer entrant,Integer sum) {
        super(name, sum);
        this.dimission = 0;
        this.entrant = entrant;
        this.aDouble = 0d;
    }

    public Integer getDimission() {
        return dimission;
    }

    public void setDimission(Integer dimission) {
        this.dimission = dimission;
    }

    public Integer getEntrant() {
        return entrant;
    }

    public void setEntrant(Integer entrant) {
        this.entrant = entrant;
    }



    public Double getaDouble() {
        return aDouble;
    }

    public void setaDouble(Double sum) {
        this.aDouble = sum;
    }
}
