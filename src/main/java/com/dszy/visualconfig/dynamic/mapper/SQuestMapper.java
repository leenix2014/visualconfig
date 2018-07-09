package com.dszy.visualconfig.dynamic.mapper;

import com.dszy.visualconfig.dynamic.entity.SQuestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SQuestMapper {

    @Select("SELECT * FROM s_quest")
    List<SQuestEntity> getAll();
}
