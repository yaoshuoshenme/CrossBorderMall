package com.edu.mapper;

import com.edu.pojo.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartMapper {

    int insert(Integer uid);



    Cart selectByUid(Integer uid);



}