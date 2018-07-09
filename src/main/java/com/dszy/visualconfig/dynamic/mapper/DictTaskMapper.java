package com.dszy.visualconfig.dynamic.mapper;

import com.dszy.visualconfig.dynamic.entity.DictActivityEntity;
import com.dszy.visualconfig.dynamic.entity.DictTaskEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DictTaskMapper {

    @Select("SELECT * FROM dict_task where activityId = #{activityId}")
    List<DictTaskEntity> getAll(Integer activityId);
}
