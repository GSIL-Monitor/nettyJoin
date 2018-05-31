package com.domain.model;

import com.netty.dao.pojo.User;

import java.util.Date;

/**
 * 用户体系
 *
 * @author anthony_xu
 * @create $ID: UserModel, v0.1 2018年05月26日 22:05 anthony_xu Exp $
 */
public class UserModel {

    private Long id;

    private String username;

    private String certName;

    private String certNo;

    private String mobile;

    public UserModel() {
    }

    public UserModel(User userDO) {
        this.setId(userDO.getId());
        this.setUsername(userDO.getUsername());
        this.setCertName(userDO.getCertName());
        this.setCertNo(userDO.getCertNo());
        this.setMobile(userDO.getMobile());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
