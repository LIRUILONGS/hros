package com.liruilong.hros.controller.statistics;

import com.liruilong.hros.model.datas.DataModel;
import com.liruilong.hros.service.EmployeecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description :
 * @Author: Liruilong
 * @Date: 2020/1/21 13:28
 */
@RequestMapping("/statistics/score")
@RestController
public class ScoreController {

    @Autowired
    EmployeecService employeecService;
    @GetMapping("/")
    public List<DataModel> getModelandView(){
          return employeecService.getModelandView();
    }
}
