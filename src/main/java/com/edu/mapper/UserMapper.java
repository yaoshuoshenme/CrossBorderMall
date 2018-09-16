package com.edu.mapper;

import com.edu.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);


    User selectByPrimaryKey(Integer uid);


    int updateByPrimaryKey(User record);

    User selectByName(String uName);

    User selectByMail(String umail);

}