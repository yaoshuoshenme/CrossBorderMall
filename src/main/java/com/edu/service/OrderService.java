package com.edu.service;

import com.edu.pojo.OrderItem;
import com.edu.pojo.OrderList;
import com.edu.vo.OrderVo;

import java.util.List;


public interface OrderService {

    boolean save(OrderList record);

    OrderVo queryByOid(Integer oid);

    List<OrderList> queryByUid(Integer uid);

    boolean updateFlag(Integer oid , Integer flag);


    boolean createOrder(Integer uid, String ciids, int aid);
}
