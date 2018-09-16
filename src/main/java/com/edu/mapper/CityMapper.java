package com.edu.mapper;

import com.edu.pojo.City;

import java.util.List;

public interface CityMapper {


    City selectById(Integer id);
    List<City> selectByPid(Integer id);

}