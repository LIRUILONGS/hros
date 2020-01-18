package com.liruilong.hros.mapper;

import com.liruilong.hros.model.Employee;
import com.liruilong.hros.model.EmployeeRecycle;
import com.liruilong.hros.model.datas.DataModel;
import com.liruilong.hros.model.datas.DataModels;

import java.util.List;

public interface EmployeeRecycleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeRecycle record);

    int insertSelective(Employee record);

    List<EmployeeRecycle> selectByPrimaryKey( );

    int updateByPrimaryKeySelective(EmployeeRecycle record);

    int updateByPrimaryKey(EmployeeRecycle record);

    List<DataModel>  dataViewDepartment();

    List<DataModels>  dataViewPosition();

    List<DataModels>  dataViewJobLevelT();
}