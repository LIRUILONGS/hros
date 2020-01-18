package com.liruilong.hros.mapper;

import com.liruilong.hros.model.RwardsAndPunishments;

import java.util.List;

public interface RwardsAndPunishmentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RwardsAndPunishments record);

    int insertSelective(RwardsAndPunishments record);

    RwardsAndPunishments selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RwardsAndPunishments record);

    int updateByPrimaryKey(RwardsAndPunishments record);

    List<RwardsAndPunishments>  getAllRwardsAndPunishments();
}