package com.edu.service;

import com.edu.pojo.Cart;
import com.edu.pojo.Cartitem;

import java.util.List;

public interface CartService {
    boolean insert(Integer uid);
    Cart querytByUid(Integer uid);


}
