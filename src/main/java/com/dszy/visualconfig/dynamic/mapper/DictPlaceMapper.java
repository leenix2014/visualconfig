package com.dszy.visualconfig.dynamic.mapper;

import com.dszy.visualconfig.dynamic.entity.DictPlaceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DictPlaceMapper {

    @Select("SELECT * FROM dict_place where placeID like '${productId}%'")
    List<DictPlaceEntity> getAll(@Param("productId")Integer productId);
}
