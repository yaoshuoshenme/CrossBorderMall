package com.edu.mapper;

import com.edu.pojo.Country;

import java.util.List;

public interface CountryMapper {

    Country selectById(Integer id);
    List<Country> selectByCityId(Integer id);

}