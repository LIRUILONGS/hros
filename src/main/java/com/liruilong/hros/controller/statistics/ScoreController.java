package com.liruilong.hros.controller.statistics;

import com.liruilong.hros.mapper.EmployeeMapper;
import com.liruilong.hros.model.Department;
import com.liruilong.hros.model.Employee;
import com.liruilong.hros.model.Salary;
import com.liruilong.hros.model.datas.DataModel;
import com.liruilong.hros.service.EmployeeService;
import com.liruilong.hros.service.EmployeecService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description :

 * @Date: 2020/1/21 13:28
 */
@RequestMapping("/statistics/score")
@RestController
public class ScoreController {

    @Autowired
    EmployeecService employeecService;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmployeeService employeeService;
    @GetMapping("/")
    @Scheduled(cron = "0 0 3 * * ?")
    public List<DataModel> getModelandView(){
          return employeecService.getModelandView();
    }

    private static List<Employee> list = new ArrayList<>();

    @Scheduled(cron = "0/3 * * * * ?")

    public ArrayList<Employee>  getEmpList() {
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
        list = arrayList;
        return arrayList;
    }


    @GetMapping("/getSalaryData")
    public   List<SalaryData> getSalaryData() {

        List<Employee> employeeAll = list;
        if (CollectionUtils.isEmpty(employeeAll)){
            employeeAll = getEmpList();
        }

        Map<Integer, Department> departmentMap = employeeAll.stream().collect(Collectors.toMap(Employee::getDepartmentid, e->e.getDepartment(), (m1, m2) -> m1));

        Map<Integer, List<Employee>> depMap = employeeAll.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(Employee::getDepartmentid));
        List<SalaryData> list = new ArrayList<>();

        depMap.forEach((k,v)->{

            // 一个部门平均薪资
            Integer sum = v.stream().map(Employee::getSalary).filter(Objects::nonNull).map(Salary::getAllsalary).filter(Objects::nonNull).reduce(Integer::sum).orElse(0);

            BigDecimal divide = new BigDecimal(sum).divide(BigDecimal.valueOf(v.size()));
            Department department = departmentMap.get(k);

            SalaryData salaryData = new SalaryData();
            salaryData.set部门名称(department.getName());
            salaryData.set平均薪资(String.valueOf(divide.doubleValue()));
            list.add(salaryData);
        });

        return list;

    }
    public static class SalaryData{
        private String 部门名称;

        private String 平均薪资;

        public String get部门名称() {
            return 部门名称;
        }

        public void set部门名称(String 部门名称) {
            this.部门名称 = 部门名称;
        }

        public String get平均薪资() {
            return 平均薪资;
        }

        public void set平均薪资(String 平均薪资) {
            this.平均薪资 = 平均薪资;
        }
    }

}
