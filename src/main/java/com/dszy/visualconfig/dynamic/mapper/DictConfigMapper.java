package com.dszy.visualconfig.dynamic.mapper;

import com.dszy.visualconfig.dynamic.entity.DictActivityEntity;
import com.dszy.visualconfig.dynamic.entity.DictConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DictConfigMapper {

    @Select("SELECT * FROM dict_config where productId = #{productId}")
    List<DictConfigEntity> getAll(Integer productId);
}
