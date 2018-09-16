package com.edu.service.impl;

import com.edu.mapper.UserMapper;
import com.edu.pojo.User;
import com.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper um;


    @Override
    @Transactional(readOnly = true)
    public User selectByName(String uname) {
        User user = um.selectByName(uname);

        return user;
    }

    @Override
    public int register(User user) {

        return  um.insert(user);
    }

    @Override
    public User selectByMail(String umail) {
        User user = um.selectByMail(umail);
        return user;
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return um.updateByPrimaryKey(user);
    }
}
