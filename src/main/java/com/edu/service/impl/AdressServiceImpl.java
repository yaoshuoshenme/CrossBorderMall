package com.edu.service.impl;

import com.edu.mapper.AddressMapper;
import com.edu.pojo.Address;
import com.edu.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper am;

    @Override
    public boolean deleteByAid(Integer aid) {
        return am.deleteByAid(aid) > 0;
    }

    @Override
    public boolean insert(Address record) {

        return am.insert(record) > 0;
    }

    @Override
    public Address selectByAid(Integer aid) {
        return am.selectByAid(aid);
    }

    @Override
    public boolean updateByAid(Address record) {
        return am.updateByAid(record) > 0;
    }

    @Override
    public List<Address> selectAll(Integer uid) {
        return am.selectAll(uid);
    }

    @Override
    public boolean updateDefault(Integer uid, Integer aid) {
        return am.updateDefault(uid,aid) > 0;
    }
}
