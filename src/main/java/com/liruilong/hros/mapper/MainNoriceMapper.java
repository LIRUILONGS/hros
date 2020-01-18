package com.liruilong.hros.mapper;

import com.liruilong.hros.model.MainNorice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MainNoriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MainNorice record);

    int insertSelective(MainNorice record);

    MainNorice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MainNorice record);

    int updateByPrimaryKeyWithBLOBs(MainNorice record);

    int updateByPrimaryKey(MainNorice record);

    List<MainNorice> getAllsMainNorice(@Param("page") Integer page, @Param("size") Integer size,@Param("keyword") String keyword);

    List<MainNorice>  getAllsMainNoricebody();

    Long  gettotal();

    Integer deldteMainNorices(@Param("ids") Integer[] ids);
}