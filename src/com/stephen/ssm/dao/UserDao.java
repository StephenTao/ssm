package com.stephen.ssm.dao;

import java.util.List;

import com.stephen.ssm.base.IBaseDao;
import com.stephen.ssm.model.User;

public interface UserDao extends IBaseDao<User, Integer> {

    List<User> findByName(String name);

    List<User> find(String key);
}
