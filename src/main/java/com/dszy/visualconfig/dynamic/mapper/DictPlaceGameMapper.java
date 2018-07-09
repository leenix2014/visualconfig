package com.dszy.visualconfig.dynamic.mapper;

import com.dszy.visualconfig.dynamic.entity.DictPlaceGameEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DictPlaceGameMapper {

    @Select("SELECT * FROM dict_place_game where placeID like '${productId}%'")
    List<DictPlaceGameEntity> getAll(@Param("productId")Integer productId);
}
