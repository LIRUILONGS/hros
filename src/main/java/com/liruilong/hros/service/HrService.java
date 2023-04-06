package com.liruilong.hros.service;

import com.liruilong.hros.mapper.HrMapper;
import com.liruilong.hros.mapper.HrRoleMapper;
import com.liruilong.hros.mapper.RoleMapper;
import com.liruilong.hros.model.Hr;
import com.liruilong.hros.model.OpLog;
import com.liruilong.hros.service.utils.Hruitls;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description :

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

    @Autowired
    RoleMapper roleMapper;

    private static Logger Loggerlogger = Logger.getLogger("HrService");

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
    public Hr getBaseHr() {
        Hr hr = hrMapper.loadUserByEmployeeId(Hruitls.getCurrent().getEmployeeId());
        if (hr == null){
            hr = hrMapper.loadUserByUsername(Hruitls.getCurrent().getUsername());
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    /**
     * 修改密码
     * @param password
     * @param rePassword
     * @return
     */
    public boolean modifyPass(String password,String rePassword) {
        Hr hr = getBaseHr();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password, hr.getPassword())) {
            String encode = encoder.encode(rePassword);
            rePassword = encode;
            hr.setPassword(rePassword);
            hrMapper.updateByPrimaryKey(hr);
            return true;
        }else {
            return false;
        }
    }

    public boolean wordDate(String wordDate) {
        Hr hr = getBaseHr();
        List<String> collect = Arrays.stream(Optional.ofNullable(hr.getWorkDate()).orElse(StringUtils.EMPTY).split(",")).filter(StringUtils::isNoneBlank).collect(Collectors.toList());
        collect.add(wordDate);
        String wordDateStr = collect.stream().collect(Collectors.joining(","));

        hr.setWorkDate(wordDateStr);
        hrMapper.updateWorkDate(hr);
        return true;
    }


    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        Integer[] rids2 =  Stream.of(rids).filter(Objects::nonNull).toArray(Integer[]::new);

        oplogService.addOpLog(new OpLog((byte) 8,new Date(),"操作员角色更新", Hruitls.getCurrent().getName()));
        Loggerlogger.warning("hrid:"+hrid + Arrays.toString(rids2));
        int i = hrRoleMapper.deleteByHeId(hrid);
        if (rids2 == null || rids2.length == 0) {
            return true;
        } else {
            return i >= 0 && hrRoleMapper.addHrRole(hrid, rids2) == rids2.length;
        }
    }

    public Integer updateHr(Hr hr) {
        oplogService.addOpLog(new OpLog((byte) 8, new Date(), "操作员信息更新:" + hr.getName(), Hruitls.getCurrent().getName()));
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    public Integer addHr(Hr hr) {
        oplogService.addOpLog(new OpLog((byte) 8, new Date(), "操作员信息更新:" + hr.getName(), Hruitls.getCurrent().getName()));
        hr.setPassword("$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm");
        if (StringUtils.isBlank(hr.getUserface())){
            hr.setUserface("https://imgsa.baidu.com/forum/pic/item/a832bc315c6034a8df786e5ac31349540823766e.jpg");
        }
        return hrMapper.insert(hr);
    }

    public Integer deleteHrById(Integer id) {
        if (id == null){
            return 0;
        }
        Hr hr = hrMapper.selectByPrimaryKey(id);
        if (hr == null){
            return 0;
        }
        if ("员工角色".equals(hr.getName())){
            return 3;
        }
        oplogService.addOpLog(new OpLog((byte) 8, new Date(), "删除操作员: id=" + id, Hruitls.getCurrent().getName()));
        return hrMapper.deleteByPrimaryKey(id);
    }

    public List<Hr> getAllHrsExceptCurrentHr() {
        return hrMapper.getAllHrsExceptCurrentHr(Hruitls.getCurrent().getId());
    }


}
