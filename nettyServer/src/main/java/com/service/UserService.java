package com.service;

import com.domain.model.UserModel;

import java.util.List;

/**
 * @author anthony_xu
 * @create $ID: UserService, v0.1 2018年05月26日 22:04 anthony_xu Exp $
 */
public interface UserService {

    List<UserModel> queryUserList(UserModel param);

    List<UserModel> queryUsersDynamic(UserModel param);

    int insertUser(UserModel userModel);
}
