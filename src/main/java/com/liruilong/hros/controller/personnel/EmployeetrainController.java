package com.liruilong.hros.controller.personnel;

import com.liruilong.hros.model.*;
import com.liruilong.hros.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description :

 * @Date: 2020/1/12 12:27
 */
@RestController
@RequestMapping("/personnel/train")
public class EmployeetrainController {


    @Autowired
    EmployeetrainService employeetrainService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    PositionService positionService;

    @Autowired
    AppraiseService appraiseService;


    @GetMapping("/init")
    public RespPageBean getEmploteeByPgeT(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmploteeByPgeT(page, size, employee, beginDateScope);

    }
    @GetMapping("/inia")
    public RespPageBean getEmploteeByPgeA(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmploteeByPgeA(page, size, employee, beginDateScope);

    }
    @GetMapping("/initapp")
    public RespPageBean getAppraiseByPge(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getAppraiseByPge(page, size, employee, beginDateScope);

    }



    @PostMapping("/")
    public RespBean addEmployeetrain(@RequestBody Employeetrain employeetrain) {
        if (employeetrainService.addEmployeetrain(employeetrain) == 1) {
            return RespBean.ok("添加成功");
        } else {
            return RespBean.error("添加失败");
        }
    }
    @PostMapping("/add")
    public RespBean addAppraise(@RequestBody Appraise appraise) {
        if (appraiseService.addAppraise(appraise) == 1) {
            return RespBean.ok("添加成功");
        } else {
            return RespBean.error("添加失败");
        }
    }

    @PutMapping("/")
    public RespBean updateEmployeetrain(@RequestBody Employeetrain employeetrain) {
        if (employeetrainService.updateEmployeetrain(employeetrain) == 1) {
            return RespBean.ok("更新成功");
        } else {
            return RespBean.error("更新失败");
        }
    }
    @PutMapping("/app")
    public RespBean updateAppraise(@RequestBody Appraise appraise) {
        if (appraiseService.updateAppraise(appraise) == 1) {
            return RespBean.ok("更新成功");
        } else {
            return RespBean.error("更新失败");
        }
    }

    /**
     * @return RespBean
     * @Author liruilong
     * @Description 删除
     * @Date 22:35 2020/1/13
     * @Param [eid, id]
     **/

    @DeleteMapping("/{eid}/{id}")
    public RespBean deleteEmployeetrain(@PathVariable Integer eid, @PathVariable Integer id){
        if (employeetrainService.deleteEmployeetrain(eid,id) == 1) {
            return RespBean.ok("取消成功!");
        }
        return RespBean.error("取消失败!");
    }

    @DeleteMapping("/app/{eid}/{id}")
    public RespBean deleteAppraise(@PathVariable Integer eid, @PathVariable Integer id){
        if (appraiseService.deleteAppraise(eid,id) == 1) {
            return RespBean.ok("取消成功!");
        }
        return RespBean.error("取消失败!");
    }


    @GetMapping("/")
    public RespPageBean getEmploteetByPge(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmploteetByPge(page, size, employee, beginDateScope);

    }

    /**
     * @Author liruilong
     * @Description 批量处理
     * @Date 22:35 2020/1/13
     * @Param [employeetrain, ids, beginDateScope]
     * @return RespBean
     **/

    @GetMapping("/addt")
    public RespBean addEmploteetByPge(Employeetrain employeetrain, Integer[] ids, Date[] beginDateScope) {

        if (employeetrainService.addEmploteetByPge(employeetrain, ids) == ids.length) {
            return RespBean.ok("添加成功");
        } else {
            return RespBean.error("添加失败");
        }
    }
    @GetMapping("/adda")
    public RespBean addEmploteetByPge(Appraise appraise, Integer[] ids) {

        if (appraiseService.addEmploteeaByPge(appraise, ids) == ids.length) {
            return RespBean.ok("添加成功");
        } else {
            return RespBean.error("添加失败");
        }
    }

    @GetMapping("/joblevels")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }


}




