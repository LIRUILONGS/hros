package com.liruilong.hros.service;

import com.liruilong.hros.mapper.HrMapper;
import com.liruilong.hros.mapper.HrRoleMapper;
import com.liruilong.hros.model.Hr;
import com.liruilong.hros.model.OpLog;
import com.liruilong.hros.service.utils.Hruitls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.LoggingPermission;

/**
 * @Description :
 * @Author: Liruilong
 * @Date: 2019/12/18 18:59
 */
@Transactional
@Service
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;
    @Autowired
    HrRoleMapper hrRoleMapper;
    @Autowired
    OplogService oplogService;

    private static Logger Loggerlogger = Logger.getLogger("com.liruilong.hros.service.HrService");

    // 根据用户名加载user对象
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHRs(String name) {
        return hrMapper.getAllHRs(Hruitls.getCurrent().getId(), name);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        oplogService.addOpLog(new OpLog((byte) 8,new Date(),"操作员角色更新", Hruitls.getCurrent().getName()));
        Loggerlogger.warning("hrid:"+hrid + Arrays.toString(rids));
        int i = hrRoleMapper.deleteByHeId(hrid);
        if (rids == null || rids.length == 0) {
            return true;
        } else {
            return i >= 0 && hrRoleMapper.addHrRole(hrid, rids) == rids.length;
        }
    }

    public Integer updateHr(Hr hr) {
        oplogService.addOpLog(new OpLog((byte) 8,new Date(),"操作员信息更新:" + hr.getName(), Hruitls.getCurrent().getName()));
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    public Integer deleteHrById(Integer id) {
        oplogService.addOpLog(new OpLog((byte) 8,new Date(),"删除操作员: id=" + id, Hruitls.getCurrent().getName()));
        return hrMapper.deleteByPrimaryKey(id);
    }

    public List<Hr> getAllHrsExceptCurrentHr() {
      return hrMapper.getAllHrsExceptCurrentHr(Hruitls.getCurrent().getId());
    }
}
