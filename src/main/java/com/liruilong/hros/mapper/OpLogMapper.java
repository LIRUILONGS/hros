package com.liruilong.hros.mapper;

import com.liruilong.hros.model.OpLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OpLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OpLog record);

    int insertSelective(OpLog record);

    Long selectByPrimaryKey(@Param("logtype") Integer logtype, @Param("beginDateScope") Date[] beginDateScope );

    int updateByPrimaryKeySelective(OpLog record);

    int updateByPrimaryKey(OpLog record);

    List<OpLog>  getAllsOplog(@Param("page") Integer page, @Param("size") Integer size,@Param("logtype") Integer logtype, @Param("beginDateScope") Date[] beginDateScope  );

    List<OpLog>  getAllsOplogm();
}