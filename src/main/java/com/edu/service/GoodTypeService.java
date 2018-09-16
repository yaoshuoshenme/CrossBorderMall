package com.edu.service;

import com.edu.pojo.GoodType;

import java.util.List;

public interface GoodTypeService {
    List<GoodType> queryByLevel(Integer gtlevel);

}
