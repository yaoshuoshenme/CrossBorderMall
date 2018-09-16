package com.edu.mapper;

import com.edu.pojo.Province;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceMapper {

    Province selectByPid(Integer pid);
    List<Province> selectAll();
}