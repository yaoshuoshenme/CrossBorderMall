package com.edu.vo;

import com.edu.pojo.Address;
import com.edu.pojo.OrderItem;
import com.edu.pojo.OrderList;

import java.util.List;

public class OrderVo {
    private OrderList order;
    private List<OrderItem> orderItems;
    private Address address;


    public OrderList getOrder() {
        return order;
    }

    public void setOrder(OrderList order) {
        this.order = order;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
