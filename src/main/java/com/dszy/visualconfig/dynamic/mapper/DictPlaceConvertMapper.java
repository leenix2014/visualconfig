package com.dszy.visualconfig.dynamic.mapper;

import com.dszy.visualconfig.dynamic.entity.DictActivityEntity;
import com.dszy.visualconfig.dynamic.entity.DictPlaceConvertEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DictPlaceConvertMapper {

    @Select("SELECT * FROM dict_place_convert where firstID = #{productId}")
    List<DictPlaceConvertEntity> getAll(Integer productId);
}
