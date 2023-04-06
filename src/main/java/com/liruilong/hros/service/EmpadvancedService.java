package com.liruilong.hros.service;

import com.liruilong.hros.mapper.EmployeeMapper;
import com.liruilong.hros.model.Employee;
import com.liruilong.hros.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description :

 * @Date: 2020/1/21 9:17
 */
@Service
public class EmpadvancedService {


    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    OplogService oplogService;
    @Autowired
    EmployeeRecycleService employeeRecycleService;


    public RespPageBean getAllsEmpadvanced(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getAllsEmpadvanced(page, size, employee, beginDateScope);
        Long total = employeeMapper.getTotalE(employee, beginDateScope);
        return new RespPageBean(total, data);
    }
}
