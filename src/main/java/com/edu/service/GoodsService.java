package com.edu.service;

import com.edu.pojo.Goods;

import java.util.List;

public interface GoodsService {

    Goods queryById(Integer gid);
    List<Goods> queryByTid(Integer tid);
}
