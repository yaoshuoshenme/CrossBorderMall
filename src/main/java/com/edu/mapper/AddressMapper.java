package com.edu.mapper;

import com.edu.pojo.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressMapper {
    int deleteByAid(Integer aid);

    int insert(Address record);

    Address selectByAid(Integer aid);

    int updateByAid(Address record);

    int updateDefault(@Param("uid") Integer uid, @Param("aid") Integer aid);

    List<Address> selectAll(Integer uid);
}