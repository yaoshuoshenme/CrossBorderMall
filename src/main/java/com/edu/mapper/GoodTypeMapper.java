package com.edu.mapper;

import com.edu.commons.GoodTypeDynaSqlProvider;
import com.edu.pojo.GoodType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodTypeMapper {


    @Select("select *from goodtype where gtid=#{gtid}")
    @ResultType(GoodType.class)
    GoodType selectByPrimaryKey(String gtid);


    @Select("select *from goodtype gt where gtlevel= #{gtlevel}")
    @ResultType(GoodType.class)
    List<GoodType> queryByLevel(Integer level);

    @Select("select gtid from goodtype where gtname = #{gtname}")
    GoodType findByName(String gtname);

    @SelectProvider(type = GoodTypeDynaSqlProvider.class,method = "selectWithParam")
    List<GoodType> selectActive(Map<String, Object> map);

}