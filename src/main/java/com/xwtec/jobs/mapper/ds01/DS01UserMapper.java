package com.xwtec.jobs.mapper.ds01;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DS01UserMapper {

    @Select("select * from twp_menu")
    //@Select("select * from TU_BASE_TWP")
    List<Map> queryAll();
}
