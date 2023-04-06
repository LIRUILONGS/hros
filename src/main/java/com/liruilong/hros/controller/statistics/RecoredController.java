package com.liruilong.hros.controller.statistics;

import com.liruilong.hros.model.datas.DataModelT;
import com.liruilong.hros.service.DataModelTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Description : 人事记录统计

 * @Date: 2020/1/6 16:11
 */
@RestController
@RequestMapping("/statistics/recored")
public class RecoredController {

    @Autowired
    DataModelTService dataModelTService;


    /**
     * @return java.util.List<DataModelT>
     * @Author liruilong
     * @Description 部门入职统计，离职统计 离职率
     * @Date 10:58 2020/1/7
     * @Param []
     **/
    @Scheduled(cron = "0 0 3 * * ?")
    @GetMapping("/department")
      public List<DataModelT> dataViewDepartment(){
          return   dataModelTService.dataViewDepartment();
      }

    /**
     * @return java.util.List<DataModelT>
     * @Author liruilong
     * @Description 职位入职统计，离职统计 离职工龄 离职率
     * @Date 16:33 2020/1/7
     * @Param []
     **/
     @Scheduled(cron = "0 0 3 * * ?")
      @GetMapping("/workAge")
    public List<DataModelT> dataViewWorkAge(){
        return dataModelTService.dataViewWorkAge();
      }

    /**
     * @return java.util.List<DataModelT>
     * @Author liruilong
     * @Description 职称入职统计，离职统计 离职工龄 离职率
     * @Date 16:51 2020/1/7
     * @Param []
     **/
    @GetMapping("/JobLevel")
    @Scheduled(cron = "0 0 3 * * ?")
    public List<DataModelT> DataViewJobLevelT(){
        return dataModelTService.dataViewJobLevelT();
    }

    /**
     * @Author liruilong
     * @Description
     * @Date 16:54 2020/1/7
     * @Param []
     * @return java.util.List<DataModelT>
     **/


    @GetMapping("/Department")
    @Scheduled(cron = "0 0 3 * * ?")
    public List<DataModelT> DataViewDepartment(){
        return dataModelTService.dataViewDepartment();
    }


}
