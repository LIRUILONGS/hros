package com.liruilong.hros.controller.salary;

import com.liruilong.hros.model.Employee;
import com.liruilong.hros.model.RespPageBean;
import com.liruilong.hros.service.EmployeeService;
import com.liruilong.hros.service.SalaryService;
import com.liruilong.hros.service.utils.POIUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description :

 * @Date: 2020/1/15 9:48
 */
@RestController
@RequestMapping("/salary/table")
public class SalartTableController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getAllsalarts(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getAllsalarts(page, size, employee, beginDateScope);
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> export() {
        int pageNum = 1;
        int pageSize = 100;
        ArrayList<Employee> arrayList = new ArrayList<>();
        while (true) {
            List<Employee> list = (List<Employee>) employeeService.getEmployeeByPageWithSalary(pageNum, pageSize).getData();
            if (CollectionUtils.isEmpty(list)) {
                break;
            }
            arrayList.addAll(list);
            pageNum++;
        }
        return POIUtils.employeeSalary2Excel(arrayList);
    }
}
