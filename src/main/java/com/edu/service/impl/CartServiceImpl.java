package com.edu.service.impl;

import com.edu.mapper.CartMapper;
import com.edu.pojo.Cart;
import com.edu.pojo.Cartitem;
import com.edu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cm;

    @Override
    public boolean insert(Integer uid) {
        return cm.insert(uid) > 0;
    }

    @Override
    public Cart querytByUid(Integer uid) {
        return cm.selectByUid(uid);
    }


}
