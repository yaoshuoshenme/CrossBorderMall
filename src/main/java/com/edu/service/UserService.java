package com.edu.service;

import com.edu.pojo.User;

public interface UserService {
    User selectByName(String uname);

    int register(User user);

    User selectByMail(String umail);

    int updateByPrimaryKey(User user);
}
