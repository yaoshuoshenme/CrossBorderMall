package com.edu.mapper;

import com.edu.pojo.Paylog;

public interface PaylogMapper {

    int insert(Paylog record);


    Paylog selectByOid(Integer Oid);


    int updateByFlag(Integer flag);
}