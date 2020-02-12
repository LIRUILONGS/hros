package com.liruilong.hros.mapper;

import com.liruilong.hros.model.Hr;
import com.liruilong.hros.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    /**
     * @return com.liruilong.hros.model.Hr
     * @Author Liruilong
     * @Description 登录
     * @Date 19:06 2019/12/18
     * @Param [username]
     **/

    Hr loadUserByUsername(String username);

    /**
     * @return java.util.List<com.liruilong.hros.model.Role>
     * @Author Liruilong
     * @Description 获取当前用户的所用角色
     * @Date 23:23 2019/12/24
     * @Param [id]
     **/

    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHRs(@Param("id") Integer id, @Param("name") String name);


    List<Hr>  getAllHrsExceptCurrentHr(Integer id);
}