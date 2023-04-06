package com.liruilong.hros.service;

import com.liruilong.hros.mapper.MenuMapper;
import com.liruilong.hros.mapper.MenuRoleMapper;
import com.liruilong.hros.model.Menu;
import com.liruilong.hros.model.OpLog;
import com.liruilong.hros.service.utils.Hruitls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Description : 菜单处理

 * @Date: 2019/12/21 13:17
 */
@Transactional
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    MenuRoleMapper menuRoleMapper;

    @Autowired
    OplogService oplogService;

    /**
     * @return java.util.List<Menu>
     * @Author liruilong
     * @Description 根据角色id获取权限菜单
     * @Date 22:20 2019/12/22
     * @Param []
     **/
    public List<Menu> getMenusById() {
        return menuMapper.getMenusByHrId(Hruitls.getCurrent().getId());
    }

    /**
     * @return java.util.List<Menu>
     * @Author liruilong
     * @Description 获取所有权限菜单, springSecurity鑒權處理
     * @Date 17:48 2019/12/24
     * @Param []
     **/
    // @Cacheable
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    /**
     * @return java.util.List<Menu>
     * @Author liruilong
     * @Description 菜单数据初始化，系統設置裏的系統菜單處理。
     * @Date 21:13 2019/12/26
     * @Param []
     **/

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    /**
     * @return java.util.List<java.lang.Integer>
     * @Author liruilong
     * @Description 获取当前角色权限
     * @Date 20:42 2019/12/26
     * @Param [rid]
     **/
    public List<Integer> getMidsByRid(Integer rid) {

        return menuRoleMapper.getMidsByRid(rid);

    }

    /**
     * @return boolean
     * @Author liruilong
     * @Description 更新信息
     * @Date 21:12 2019/12/26
     * @Param [rid, mids]
     **/

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {

        oplogService.addOpLog(new OpLog((byte) 1, new Date(), "角色权限变更", Hruitls.getCurrent().getName()));

        menuRoleMapper.deleteByRid(rid);
        if (mids != null && mids.length > 0) {
            Integer result = menuRoleMapper.insertRecord(rid, mids);
            return result == mids.length;
        } else {
            return true;
        }
    }
}
