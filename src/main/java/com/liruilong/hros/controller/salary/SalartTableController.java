package com.liruilong.hros.controller.salary;

import com.liruilong.hros.model.Employee;
import com.liruilong.hros.model.RespPageBean;
import com.liruilong.hros.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description :
 * @Author: Liruilong
 * @Date: 2020/1/15 9:48
 */
@RestController
@RequestMapping("/salary/table")
public class SalartTableController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping("/")
    public RespPageBean getAllsalarts(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope){
       return employeeService.getAllsalarts(page,size,employee,beginDateScope);
    }
}
