package com.liruilong.hros.controller.system.basic;


import com.liruilong.hros.model.Menu;
import com.liruilong.hros.model.RespBean;
import com.liruilong.hros.model.Role;
import com.liruilong.hros.service.MenuService;
import com.liruilong.hros.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author liruilong
 * @Description
 * @Date 17:21 2019/12/26
 * @Param
 * @return
 **/

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    /**
     * @return java.util.List<Menu>
     * @Author liruilong
     * @Description 系統設置裏的菜單處理
     * @Date 16:17 2020/2/14
     * @Param []
     **/

    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    private List<Integer> getMidsByRid(@PathVariable Integer rid) {
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新成功");
        } else {
            return RespBean.error("更新失败");
        }
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid) {
        if (roleService.deleteRoleById(rid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}


