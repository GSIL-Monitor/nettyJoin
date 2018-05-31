package com.service;

import com.alibaba.fastjson.JSON;
import com.domain.model.UserModel;
import com.google.common.collect.Lists;
import com.netty.dao.mapper.UserMapper;
import com.netty.dao.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author anthony_xu
 * @create $ID: UserServiceImpl, v0.1 2018年05月26日 22:07 anthony_xu Exp $
 */
@Service
public class UserServiceImpl implements UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserModel> queryUserList(UserModel param) {
        return convertDoToModel(userMapper.selectAllUser());
    }

    private List<UserModel> convertDoToModel(List<User> users) {
        List<UserModel> userModels = Lists.newArrayList();

        if (CollectionUtils.isEmpty(users)) {
            LOGGER.warn("it's empty");
            return userModels;
        }
        for (User user : users) {
            UserModel model = new UserModel(user);
            userModels.add(model);
        }

        return userModels;
    }

    @Override
    public List<UserModel> queryUsersDynamic(UserModel param) {
        User paramDO = new User();
        BeanUtils.copyProperties(param, paramDO);
        LOGGER.warn(String.format("query param %s", JSON.toJSONString(paramDO)));

        return convertDoToModel(userMapper.selectUsersDynamic(paramDO));
    }

    @Override
    public int insertUser(UserModel userModel) {
        if (userModel == null) {
            return 0;
        }

        User userDO = new User();
        BeanUtils.copyProperties(userModel, userDO);

        LOGGER.warn(String.format("insert value %s", JSON.toJSONString(userDO)));

        return userMapper.insert(userDO);
    }
}
