package com.liruilong.hros.controller.system;

import com.liruilong.hros.model.Hr;
import com.liruilong.hros.model.RespBean;
import com.liruilong.hros.model.Role;
import com.liruilong.hros.service.HrService;
import com.liruilong.hros.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description :

 * @Date: 2019/12/29 20:14
 */
@RequestMapping("/system/hr")
@RestController
public class HrController {

    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHRs(String name) {
        return hrService.getAllHRs(name);

    }

    @GetMapping("/base")
    public List<Hr> getBaseHr() {
        Hr baseHr = hrService.getBaseHr();
        List<String> collect = Arrays.stream(baseHr.getWorkDate().split(",")).collect(Collectors.toList());
        baseHr.setWorkDates(collect);
        return Collections.singletonList(baseHr);

    }

    @PostMapping("/modifyPass")
    public boolean modifyPass(@RequestBody RePass rePass) {
      return hrService.modifyPass(rePass.getPassword(), rePass.getRePassword());
    }

    @PostMapping("/wordDate")
    public boolean wordDate(@RequestBody WordDate wordDate) {
        return hrService.wordDate(wordDate.getDate());
    }



    public static class WordDate{
        private String date;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

    public static class RePass{
      private   String password;
      private  String rePassword;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRePassword() {
            return rePassword;
        }

        public void setRePassword(String rePassword) {
            this.rePassword = rePassword;
        }
    }

    @PostMapping("/add")
    public RespBean addHr(@RequestBody Hr hr) {
        if (hrService.addHr(hr) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id) {
        Integer integer = hrService.deleteHrById(id);
        if (integer== 1) {
            return RespBean.ok("删除成功!");
        }
        if(integer == 3){
            return RespBean.error("员工角色不允许删除");

        }

        return RespBean.error("删除失败!");
    }

}


