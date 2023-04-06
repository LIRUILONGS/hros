package com.liruilong.hros.service;

import com.liruilong.hros.mapper.EmployeeRecycleMapper;
import com.liruilong.hros.model.Employee;
import com.liruilong.hros.model.EmployeeRecycle;
import com.liruilong.hros.model.datas.DataModel;
import com.liruilong.hros.model.datas.DataModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description :

 * @Date: 2020/1/6 16:45
 */
@Service
public class EmployeeRecycleService {

    @Autowired
    EmployeeRecycleMapper employeeRecycleMapper;


    public void addEmployeeRecycle(Employee employee){
        employeeRecycleMapper.insertSelective(employee);

    }

    public List<EmployeeRecycle> getAllEmployeeRecycle() {
        return employeeRecycleMapper.selectByPrimaryKey();
    }

    public List<DataModel> dataViewDepartment() {
        return employeeRecycleMapper.dataViewDepartment();
    }

    public List<DataModels> dataViewPosition() {
        return employeeRecycleMapper.dataViewPosition();
    }

    public List<DataModels> dataViewJobLevelT() {
        return employeeRecycleMapper.dataViewJobLevelT();
    }
}
