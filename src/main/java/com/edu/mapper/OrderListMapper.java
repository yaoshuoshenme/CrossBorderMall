package com.edu.mapper;

import com.edu.pojo.OrderList;
import com.edu.vo.OrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderListMapper {

    int insert(OrderList record);

    OrderVo selectByOid(Integer oid);

    List<OrderList> selectByUid(Integer uid);

    int updateFlag(@Param("oid") Integer oid, @Param("flag") Integer flag);

}