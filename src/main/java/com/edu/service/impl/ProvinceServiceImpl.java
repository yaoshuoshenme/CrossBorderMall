package com.edu.service.impl;

import com.edu.mapper.CityMapper;
import com.edu.mapper.CountryMapper;
import com.edu.mapper.ProvinceMapper;
import com.edu.pojo.City;
import com.edu.pojo.Country;
import com.edu.pojo.Province;
import com.edu.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper pm;
    @Autowired
    private CityMapper cim;
    @Autowired
    private CountryMapper com;

    @Override
    public List<Province> selectAll() {
        return pm.selectAll();
    }

    @Override
    public List<City> selectByPid(Integer id) {
        return cim.selectByPid(id);
    }

    @Override
    public List<Country> selectByCityId(Integer id) {
        return com.selectByCityId(id);
    }
}
