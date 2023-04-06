package com.liruilong.hros.mapper;

import com.liruilong.hros.model.HrRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

    int deleteByHeId(Integer hrid);

    List<HrRole> selectByHrId(Integer hrid);

    int deleteByRoleId(Integer rid);


    Integer addHrRole(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);
}