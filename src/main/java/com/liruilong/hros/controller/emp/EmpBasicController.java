package com.liruilong.hros.controller.emp;

import com.liruilong.hros.model.*;
import com.liruilong.hros.service.*;
import com.liruilong.hros.service.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Description :

 * @Date: 2019/12/31 11:19
 */

@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    NationService nationService;
    @Autowired
    PoliticsstatusService politicsstatusService;
    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    PositionService positionService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeecService employeeecService;

    @GetMapping("/")
    public RespPageBean getEmploteeByPge(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmploteeByPge(page, size, employee, beginDateScope);

    }



    @DeleteMapping("/{id}")
    public RespBean deleteEmpByEid(@PathVariable Integer id) {
        if (employeeService.deleteEmpByEid(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @DeleteMapping("/many/")
    public RespBean deleteEmpByEids(Integer[] ids) {
        if (employeeService.deleteEmpByEids(ids) == ids.length) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }


    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Employee employee) {
        if (employeeService.updateEmp(employee) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations() {
        return nationService.getAllNations();
    }

    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusService.getAllPoliticsstatus();
    }

    @GetMapping("/joblevels")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/deps")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/maxWorkID")
    public RespBean maxWorkID() {
        Integer workID = employeeService.maxWorkID();
        if (workID == null) {
            workID = 0;
        }
        RespBean respBean = RespBean.build().setStatus(200)
                .setObj(String.format("%08d", workID + 1));
        return respBean;
    }

    /**
     * @return org.springframework.http.ResponseEntity<byte [ ]>
     * @Author liruilong
     * @Description 文件下载
     * @Date 19:04 2020/1/1
     * @Param []
     **/

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() {
        List<Employee> list = (List<Employee>) employeeService.getEmploteeByPge(null, null, null,null).getData();
        return POIUtils.employee2Excel(list);
    }


    /**
     * @Author liruilong
     * @Description 文件导出
     * @Date 19:48 2020/1/1
     * @Param [file]
     * @return RespBean
     **/

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list = POIUtils.excel2Employee(file, nationService.getAllNations(), politicsstatusService.getAllPoliticsstatus()
                , departmentService.getAllDepartmentsWithOutChildren(), positionService.getAllPositions(), jobLevelService.getAllJobLevels());
        if (employeeService.addEmps(list) == list.size()) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }
}
