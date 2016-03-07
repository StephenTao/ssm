package com.stephen.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.stephen.ssm.base.BaseService;
import com.stephen.ssm.dao.UserDao;
import com.stephen.ssm.model.User;
import com.stephen.ssm.service.UserService;
import com.stephen.ssm.util.StringUtil;

public class UserServiceImpl extends BaseService implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Integer create(User user) {
        if (user == null) {
            //check logic
            return null;
        }
        userDao.add(user);
        return user.getId();
    }

    @Override
    public Boolean update(User user) {
        if (user == null || user.getId() == null) {
            //check logic
            return null;
        }
        return userDao.update(user);
    }

    @Override
    public Boolean delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> findByName(String name) {
        name = name.trim();
        List<User> users = new ArrayList<User>();
        users = userDao.findByName(name);
        return users;
    }

    @Override
    public List<User> find(String key) {
        if (StringUtil.isEmpty(key)) {
            key = null;
        }
        return userDao.find(key);
    }

}
