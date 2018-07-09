package com.dszy.visualconfig.dynamic.mapper;

import com.dszy.visualconfig.dynamic.entity.DictActivityEntity;
import com.dszy.visualconfig.dynamic.entity.DictPlaceVersionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DictPlaceVersionMapper {

    @Select("SELECT * FROM dict_place_version where firstID = #{productId}")
    List<DictPlaceVersionEntity> getAll(Integer productId);
}
