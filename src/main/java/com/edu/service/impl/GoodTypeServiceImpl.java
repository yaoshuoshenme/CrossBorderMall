package com.edu.service.impl;

import com.edu.mapper.GoodTypeMapper;
import com.edu.pojo.GoodType;
import com.edu.service.GoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodTypeServiceImpl implements GoodTypeService {

    @Autowired
    private GoodTypeMapper gm;
    @Override
    public List<GoodType> queryByLevel(Integer gtlevel) {

        return gm.queryByLevel(gtlevel);
    }
}
