package com.liruilong.hros.controller.statistics;

import com.liruilong.hros.model.datas.DataModel;
import com.liruilong.hros.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description :
 * @Author: Liruilong
 * @Date: 2020/1/5 15:54
 */
@RestController
@RequestMapping("/statistics/personnel")
public class PersonnelController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/Position")
    public List<DataModel> DataViewPosition(){
        return employeeService.dataViewPosition();

    }

    @GetMapping("/JobLevel")
    public List<DataModel> DataViewJobLevel(){
        return employeeService.dataViewJobLevel();
    }

    @GetMapping("/Department")
    public List<DataModel> DataViewDepartment(){
        return employeeService.dataViewDepartment();
    }

    @GetMapping("/tiptopdegree")
    public List<DataModel> DataViewtiptopdegree(){
        return employeeService.dataViewtiptopdegree();

    }

    @GetMapping("/school")
    public List<DataModel> DataViewschool(){
        return employeeService.dataViewschool();
    }

    @GetMapping("/nation")
    public List<DataModel> DataViewNation(){
        return employeeService.dataViewNation();
    }
    @GetMapping("/politicsstatus")
    public List<DataModel> DataViewPoliticsstatus(){
        return employeeService.dataViewPoliticsstatus();
    }





}
