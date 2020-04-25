package com.ssm.dao;

import com.ssm.domian.User;

import java.util.List;

/**
 * @author: 贝阿人
 * @DATE: 2020/4/21
 * @Reference：https://www.bilibili.com/video/BV1mE411X7yp
 */
public interface UserDao {

    /**
     * query all users
     * @return List
     */
    List<User> findAllUser();
}
