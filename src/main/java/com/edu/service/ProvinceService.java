package com.edu.service;

import com.edu.pojo.City;
import com.edu.pojo.Country;
import com.edu.pojo.Province;

import java.util.List;

public interface ProvinceService {
    //查省
    List<Province> selectAll();
    //查市
    List<City> selectByPid(Integer id);
    //查县
    List<Country> selectByCityId(Integer id);
}
