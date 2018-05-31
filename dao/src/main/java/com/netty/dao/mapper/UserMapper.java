package com.netty.dao.mapper;

import com.netty.dao.pojo.User;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    List<User> selectAllUser();

    List<User> selectUsersDynamic(User param);
}