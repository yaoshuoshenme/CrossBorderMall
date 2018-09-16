package com.edu.service.impl;

import com.edu.mapper.CartitemMapper;
import com.edu.pojo.Cartitem;
import com.edu.service.CartitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartitemServiceImpl implements CartitemService {
    @Autowired
    private CartitemMapper cm;

    @Override
    public boolean deleteByPrimaryKey(Integer ciid) {
        return cm.deleteByPrimaryKey(ciid) > 0;
    }

    @Override
    public boolean deleteByCid(Integer cid) {
        return cm.deleteByCid(cid) > 0;
    }

    @Override
    public boolean save(Cartitem record) {
        return cm.insert(record) > 0;
    }

    @Override
    public Cartitem queryByCiid(Integer ciid) {
        return cm.selectByCiid(ciid);
    }

    @Override
    public List<Cartitem> queryByCid(Integer cid) {
        return cm.selectByCid(cid);
    }

    @Override
    public Boolean saveOrUpdate(Integer gid, Integer cid) {
        Cartitem ct = cm.selectByGidAndCid(gid, cid);
        if(null != ct){

            return cm.updateByCiid(ct.getCiid(), 1) > 0;
        }else{
            Cartitem cartitem = new Cartitem();
            cartitem.setCid(cid);
            cartitem.setGid(gid);
            cartitem.setCount(1);

            return cm.insert(cartitem) > 0;
        }

    }

    @Override
    public boolean updateByCiid(Integer ciid, int count) {
        return cm.updateByCiid(ciid,count) > 0;
    }

    @Override
    public List<Cartitem> selectByCiids(String ciids) {
        return cm.selectByCiids(ciids);
    }
}
