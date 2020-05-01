package com.liruilong.hros.mapper;

import com.liruilong.hros.model.Employee;

import com.liruilong.hros.model.Employeetrain;
import com.liruilong.hros.model.datas.DataModel;

import com.liruilong.hros.model.datas.DataModels;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByPrimaryKey();

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotal(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Integer maxWorkID();

    Integer addEmps(List<Employee> list);

    Employee getEmployeeById(Integer id);

    Integer deleteByPrimaryKeys(@Param("ids") Integer[] ids);

    List<Employee> getEmployeeByPageWithSalary(@Param("page") Integer page, @Param("size") Integer size);

    Integer updateEmployeeSalaryById(@Param("eid") Integer eid, @Param("sid") Integer sid);

    List<DataModel> dataViewPosition();

    List<DataModel> dataViewJobLevel();

    List<DataModel> dataViewDepartment();

    List<DataModel> dataViewNation();

    List<DataModel> DataViewPoliticsstatus();

    List<DataModels> dataViewJobLevelAge();

    List<Employee>  getEmployeecByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotalc(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    List<Employee> getEmployeetByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long  getTotalt(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    List<Employee> getEmployeeAByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotalA(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    List<Employee>  getEmployeeByPageT(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotalT(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    List<Employee> getEmployeeByPageA(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotala(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    List<Employee> getEmployeeByPageM(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotalM(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    List<Employee>  getEmployeeByPageS(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotaS(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    List<Employee> getAllsEmpadvanced(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotalE(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    List<Employee>  getEmployeeAll();
}