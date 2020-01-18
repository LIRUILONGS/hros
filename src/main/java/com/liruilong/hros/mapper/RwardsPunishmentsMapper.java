package com.liruilong.hros.mapper;

import com.liruilong.hros.model.RwardsPunishments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RwardsPunishmentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RwardsPunishments record);

    int insertSelective(RwardsPunishments record);

    RwardsPunishments selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RwardsPunishments record);

    int updateByPrimaryKey(RwardsPunishments record);

    List<RwardsPunishments> getAllRwardsPunishments();


    Integer deleteRwardsPunishmentsByIds(@Param("ids")Integer[] ids);

    List<RwardsPunishments> sercRwardsPunishments(RwardsPunishments rwardsPunishments);
}