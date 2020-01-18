package com.liruilong.hros.service;


import com.liruilong.hros.mapper.RoleMapper;
import com.liruilong.hros.model.OpLog;
import com.liruilong.hros.model.Role;
import com.liruilong.hros.service.utils.Hruitls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author Liruilong
 * @Description
 * @Date 17:37 2019/12/26
 * @Param
 * @return
 **/
@Transactional
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    OplogService oplogService;


    /**
     * @Author Liruilong
     * @Description  数据初始化
     * @Date 20:42 2019/12/26
     * @Param []
     * @return java.util.List<com.liruilong.hros.model.Role>
     **/

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    /**
     * @Author Liruilong
     * @Description  添加角色权限
     * @Date 20:42 2019/12/26
     * @Param [role]
     * @return java.lang.Integer
     **/

    public Integer addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        oplogService.addOpLog(new OpLog((byte) 1,new Date(),"添加角色: " + role.getName(), Hruitls.getCurrent().getName()));
        return roleMapper.insert(role);
    }

    /**
     * @Author Liruilong
     * @Description 删除角色
     * @Date 20:43 2019/12/26
     * @Param [rid]
     * @return java.lang.Integer
     **/

    public Integer deleteRoleById(Integer rid) {
        oplogService.addOpLog(new OpLog((byte) 1,new Date(),"删除奖惩: id = " + rid, Hruitls.getCurrent().getName()));

        return roleMapper.deleteByPrimaryKey(rid);
    }
}
