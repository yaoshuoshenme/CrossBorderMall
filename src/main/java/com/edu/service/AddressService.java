package com.edu.service;

import com.edu.pojo.Address;

import java.util.List;

public interface AddressService {
    boolean deleteByAid(Integer aid);

    boolean insert(Address record);

    Address selectByAid(Integer aid);

    boolean updateByAid(Address record);

    List<Address> selectAll(Integer uid);

    boolean updateDefault(Integer uid, Integer aid);
}
