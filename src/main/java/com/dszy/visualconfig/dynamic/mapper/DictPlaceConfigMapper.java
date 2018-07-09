package com.dszy.visualconfig.dynamic.mapper;

import com.dszy.visualconfig.dynamic.entity.DictPlaceConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DictPlaceConfigMapper {

    @Select("SELECT * FROM dict_place_config where placeID like '${productId}%'")
    List<DictPlaceConfigEntity> getAll(@Param("productId")Integer productId);
}
