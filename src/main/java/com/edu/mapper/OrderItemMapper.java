package com.edu.mapper;

import com.edu.pojo.OrderItem;

import java.util.List;

public interface OrderItemMapper {

    int insert(OrderItem record);


    OrderItem selectByOiid(Integer oiid);

    List<OrderItem> selectByOid(Integer oid);

}