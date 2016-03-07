package com.stephen.ssm.controller;

import java.util.List;

import com.stephen.ssm.base.BaseJsonController;
import com.stephen.ssm.dto.PaginationDTO;
import com.stephen.ssm.model.User;
import com.stephen.ssm.service.UserService;

public class UserController extends BaseJsonController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Integer create(User user) {
        return userService.create(user);
    }

    public Boolean update(User user) {
        return userService.update(user);
    }

    public Boolean delete(Integer id) {
        return userService.delete(id);
    }

    public User getById(Integer id) {
        return userService.getById(id);
    }

    public PaginationDTO<?> find(Integer currentPage, Integer pageSize,
            final String key){
        PaginationDTO<?> paginationDTO = pagination(currentPage, pageSize,
                new PaginationCallBack<User>() {

            @Override
            public List<User> callBack() {
                return userService.find(key);
            }
        });

        return paginationDTO;
    }
}
