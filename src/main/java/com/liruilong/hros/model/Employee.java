package com.liruilong.hros.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Employee  implements Serializable {
    private Integer id;
    private String name;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8" )
    private Date birthday;
    private String idcard;
    private String wedlock;
    private Integer nationid;
    private String nativeplace;
    private Integer politicid;
    private String email;
    private String phone;
    private String address;
    private Integer departmentid;
    private Integer joblevelid;
    private Integer posid;
    private String engageform;
    private String tiptopdegree;
    private String specialty;
    private Salary salary;
    private String school;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8" )
    private Date begindate;
    private String workstate;
    private String workid;
    private Double contractterm;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8" )
    private Date conversiontime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8" )
    private Date notworkdate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8" )
    private Date begincontract;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="GMT+8" )
    private Date endcontract;
    private Integer workage;
    private Nation nation;
    private Politicsstatus politicsstatus;
    private Position position;
    private Department department;
    private JobLevel jobLevel;
    private List<Employeeec> employeeecList;
    private Appraise appraise;
    private List<Employeeremove> employeeremoveList;

    public List<Employeeremove> getEmployeeremoveList() {
        return employeeremoveList;
    }

    public void setEmployeeremoveList(List<Employeeremove> employeeremoveList) {
        this.employeeremoveList = employeeremoveList;
    }

    public Appraise getAppraise() {
        return appraise;
    }

    public void setAppraise(Appraise appraise) {
        this.appraise = appraise;
    }

    public Employeetrain getEmployeetrainList() {
        return employeetrainList;
    }

    public void setEmployeetrainList(Employeetrain employeetrainList) {
        this.employeetrainList = employeetrainList;
    }

    private Employeetrain employeetrainList;



    public Employee(Integer id, Date notworkdate) {
        this.id = id;
        this.notworkdate = notworkdate;
    }

    public Employee() {
    }

    public Employee(Integer id, String name, String gender, Date birthday, String idcard, String wedlock, Integer nationid, String nativeplace, Integer politicid, String email, String phone, String address, Integer departmentid, Integer joblevelid, Integer posid, String engageform, String tiptopdegree, String specialty, Salary salary, String school, Date begindate, String workstate, String workid, Double contractterm, Date conversiontime, Date notworkdate, Date begincontract, Date endcontract, Integer workage, Nation nation, Politicsstatus politicsstatus, Position position, Department department, JobLevel jobLevel) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.idcard = idcard;
        this.wedlock = wedlock;
        this.nationid = nationid;
        this.nativeplace = nativeplace;
        this.politicid = politicid;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.departmentid = departmentid;
        this.joblevelid = joblevelid;
        this.posid = posid;
        this.engageform = engageform;
        this.tiptopdegree = tiptopdegree;
        this.specialty = specialty;
        this.salary = salary;
        this.school = school;
        this.begindate = begindate;
        this.workstate = workstate;
        this.workid = workid;
        this.contractterm = contractterm;
        this.conversiontime = conversiontime;
        this.notworkdate = notworkdate;
        this.begincontract = begincontract;
        this.endcontract = endcontract;
        this.workage = workage;
        this.nation = nation;
        this.politicsstatus = politicsstatus;
        this.position = position;
        this.department = department;
        this.jobLevel = jobLevel;
    }

    public List<Employeeec> getEmployeeecList() {
        return employeeecList;
    }

    public void setEmployeeecList(List<Employeeec> employeeecList) {
        this.employeeecList = employeeecList;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public Politicsstatus getPoliticsstatus() {
        return politicsstatus;
    }

    public void setPoliticsstatus(Politicsstatus politicsstatus) {
        this.politicsstatus = politicsstatus;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public JobLevel getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(JobLevel jobLevel) {
        this.jobLevel = jobLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getWedlock() {
        return wedlock;
    }

    public void setWedlock(String wedlock) {
        this.wedlock = wedlock == null ? null : wedlock.trim();
    }

    public Integer getNationid() {
        return nationid;
    }

    public void setNationid(Integer nationid) {
        this.nationid = nationid;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace == null ? null : nativeplace.trim();
    }

    public Integer getPoliticid() {
        return politicid;
    }

    public void setPoliticid(Integer politicid) {
        this.politicid = politicid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getJoblevelid() {
        return joblevelid;
    }

    public void setJoblevelid(Integer joblevelid) {
        this.joblevelid = joblevelid;
    }

    public Integer getPosid() {
        return posid;
    }

    public void setPosid(Integer posid) {
        this.posid = posid;
    }

    public String getEngageform() {
        return engageform;
    }

    public void setEngageform(String engageform) {
        this.engageform = engageform == null ? null : engageform.trim();
    }

    public String getTiptopdegree() {
        return tiptopdegree;
    }

    public void setTiptopdegree(String tiptopdegree) {
        this.tiptopdegree = tiptopdegree == null ? null : tiptopdegree.trim();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public String getWorkstate() {
        return workstate;
    }

    public void setWorkstate(String workstate) {
        this.workstate = workstate == null ? null : workstate.trim();
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
    }

    public Double getContractterm() {
        return contractterm;
    }

    public void setContractterm(Double contractterm) {
        this.contractterm = contractterm;
    }

    public Date getConversiontime() {
        return conversiontime;
    }

    public void setConversiontime(Date conversiontime) {
        this.conversiontime = conversiontime;
    }

    public Date getNotworkdate() {
        return notworkdate;
    }

    public void setNotworkdate(Date notworkdate) {
        this.notworkdate = notworkdate;
    }

    public Date getBegincontract() {
        return begincontract;
    }

    public void setBegincontract(Date begincontract) {
        this.begincontract = begincontract;
    }

    public Date getEndcontract() {
        return endcontract;
    }

    public void setEndcontract(Date endcontract) {
        this.endcontract = endcontract;
    }

    public Integer getWorkage() {
        return workage;
    }

    public void setWorkage(Integer workage) {
        this.workage = workage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", idcard='" + idcard + '\'' +
                ", wedlock='" + wedlock + '\'' +
                ", nationid=" + nationid +
                ", nativeplace='" + nativeplace + '\'' +
                ", politicid=" + politicid +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", departmentid=" + departmentid +
                ", joblevelid=" + joblevelid +
                ", posid=" + posid +
                ", engageform='" + engageform + '\'' +
                ", tiptopdegree='" + tiptopdegree + '\'' +
                ", specialty='" + specialty + '\'' +
                ", salary=" + salary +
                ", school='" + school + '\'' +
                ", begindate=" + begindate +
                ", workstate='" + workstate + '\'' +
                ", workid='" + workid + '\'' +
                ", contractterm=" + contractterm +
                ", conversiontime=" + conversiontime +
                ", notworkdate=" + notworkdate +
                ", begincontract=" + begincontract +
                ", endcontract=" + endcontract +
                ", workage=" + workage +
                ", nation=" + nation +
                ", politicsstatus=" + politicsstatus +
                ", position=" + position +
                ", department=" + department +
                ", jobLevel=" + jobLevel +
                '}';
    }
}