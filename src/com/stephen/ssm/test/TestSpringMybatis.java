package com.stephen.ssm.test;

import com.stephen.ssm.controller.UserController;
import com.stephen.ssm.dto.PaginationDTO;
import com.stephen.ssm.util.SpringUtil;

public class TestSpringMybatis {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Integer pageSize = 2;
        Integer currentPage = 1;
        UserController controller = (UserController) SpringUtil.getBean("userController");
        PaginationDTO<?> pagination = controller.find(currentPage, pageSize, null);
        System.out.println(pagination);

    }

}
