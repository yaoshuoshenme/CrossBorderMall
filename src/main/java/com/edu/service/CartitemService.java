package com.edu.service;

import com.edu.pojo.Cartitem;

import java.util.List;

public interface CartitemService {
    boolean deleteByPrimaryKey(Integer ciid);
    boolean deleteByCid(Integer cid);
    boolean save(Cartitem record);


    Cartitem queryByCiid(Integer ciid);
    List<Cartitem> queryByCid(Integer cid);
    Boolean saveOrUpdate(Integer gid, Integer cid);
    boolean updateByCiid(Integer ciid, int count);

    List<Cartitem> selectByCiids(String ciids);
}
