package com.stephen.ssm.service;

import java.util.List;

import com.stephen.ssm.model.User;

public interface UserService {

    Integer create(User user);

    Boolean update(User user);

    Boolean delete(Integer id);

    User getById(Integer id);

    List<User> findByName(String name);

    List<User> find(String key);

}
