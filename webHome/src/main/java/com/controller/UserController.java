package com.controller;

import com.domain.model.FundModel;
import com.domain.model.UserModel;
import com.google.common.collect.Lists;
import com.service.FundService;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 用户控制
 *
 * @author anthony_xu
 * @create $ID: UserController, v0.1 2018年05月26日 22:03 anthony_xu Exp $
 */
@Controller
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final ReadWriteLock rl = new ReentrantReadWriteLock();

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryUserList", method = RequestMethod.GET)
    @ResponseBody
    public List<UserModel> queryUserList(UserModel userModel, final ModelMap modelMap) {
        return userService.queryUserList(userModel);
    }

    @RequestMapping(value = "/queryUserListDynamic", method = RequestMethod.GET)
    @ResponseBody
    public List<UserModel> queryUserListDynamic(@RequestBody UserModel userModel, final ModelMap modelMap) {
        return userService.queryUsersDynamic(userModel);
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    @ResponseBody
    public int insertUser(UserModel userModel, final ModelMap modelMap) {
        return userService.insertUser(userModel);
    }
}
