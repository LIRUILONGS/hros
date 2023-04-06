package com.liruilong.hros.controller.systems;

import com.liruilong.hros.model.Menu;
import com.liruilong.hros.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description :  菜单加载

 * @Date: 2019/12/21 13:14
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;

    /**
     * @return java.util.List<Menu>
     * @Author liruilong
     * @Description 系統菜單加載
     * @Date 16:13 2020/2/14
     * @Param []
     **/

    @GetMapping("/menu")
    public List<Menu> getMenusByHrId(){
        return menuService.getMenusById();
    }
}
