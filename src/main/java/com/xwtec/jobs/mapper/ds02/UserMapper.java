package com.xwtec.jobs.mapper.ds02;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("select * from User")
    List<Map> queryAll();
}
