package com.dszy.visualconfig.dynamic.mapper;

import com.dszy.visualconfig.dynamic.entity.DictActivityEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DictActivityMapper {

    @Select("SELECT * FROM dict_activity where gameId = #{productId}")
    List<DictActivityEntity> getAll(Integer productId);
}
