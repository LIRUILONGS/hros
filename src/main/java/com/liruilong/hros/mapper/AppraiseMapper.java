package com.liruilong.hros.mapper;

import com.liruilong.hros.model.Appraise;
import org.apache.ibatis.annotations.Param;

public interface AppraiseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Appraise record);

    int insertSelective(Appraise record);

    Appraise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKey(Appraise record);

    Integer deleteAppraise(@Param("eid") Integer eid, @Param("id") Integer id);

    Integer deleteAppraiseEmpId(@Param("eid") Integer eid);


    Integer addEmploteeaByPge(@Param("app") Appraise appraise, @Param("ids") Integer[] ids);
}