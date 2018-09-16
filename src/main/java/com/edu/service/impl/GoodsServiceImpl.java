package com.edu.service.impl;

import com.edu.mapper.GoodsMapper;
import com.edu.pojo.Goods;
import com.edu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper gm;

    @Override
    public Goods queryById(Integer gid) {

        return gm.queryById(gid);
    }

    @Override
    public List<Goods> queryByTid(Integer tid) {


        return  gm.queryByTid(tid);
    }
}
