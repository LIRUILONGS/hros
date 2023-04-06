package com.liruilong.hros.controller.personnel;

import com.liruilong.hros.model.*;
import com.liruilong.hros.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description : 奖惩处理

 * @Date: 2020/1/8 20:25
 */
@RestController
@RequestMapping("/personnel/ec")
public class EmployeeecController {

    @Autowired
    EmployeeecService employeeecService;

    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    PositionService positionService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RwardsPunishmentsSevice rwardsPunishmentsSevice;



    @GetMapping("/")
    public RespBean addEmployeeec(Employeeec employeeec, Integer[] ids) {

        if (employeeecService.addEmployeeec(employeeec, ids) == ids.length) {
            return RespBean.ok("添加成功");
        } else {
            return RespBean.error("添加失败");
        }

    }

    @GetMapping("/init")
    public RespPageBean getEmploteeByPge(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmploteeByPge(page, size, employee, beginDateScope);

    }

    @GetMapping("/rp")
    public List<RwardsPunishments> getAllRwardsPunishments() {
        return rwardsPunishmentsSevice.getAllRwardsPunishments();
    }
    @GetMapping("/ec")
    public RespPageBean getEmploteecByPge(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "100") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmploteecByPge(page, size, employee, beginDateScope);
    }
    @DeleteMapping("/{eid}/{id}")
    public RespBean deleteEmpByEidc(@PathVariable Integer eid, @PathVariable Integer id) {
        if (employeeecService.deleteEmpByEidc(eid,id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
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
