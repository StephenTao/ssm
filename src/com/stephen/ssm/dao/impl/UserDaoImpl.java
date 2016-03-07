package com.stephen.ssm.dao.impl;

import java.util.List;
import java.util.Map;

import com.stephen.ssm.AppConstants;
import com.stephen.ssm.AppContext;
import com.stephen.ssm.base.BaseDao;
import com.stephen.ssm.dao.UserDao;
import com.stephen.ssm.dto.PaginationDTO;
import com.stephen.ssm.model.User;

public class UserDaoImpl extends BaseDao<User, Integer> implements UserDao {

    private static final String CLASS_NAME = User.class.getName();
    private static final String SQL_ID_FIND_BY_NAME = ".findByName";
    private static final String SQL_ID_FIND = ".find";
    private static final String SQL_ID_FIND_COUNT = ".getCount";

    @Override
    public List<User> findByName(String name) {
        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FIND_BY_NAME, name);
    }

    @Override
    public List<User> find(String key) {
        Map<String, Object> params = getParameterMap();
        params.put(AppConstants.USER_NAME, key);
        @SuppressWarnings("unchecked")
        PaginationDTO<User> paginationDTO = (PaginationDTO<User>)
            AppContext.getContext().getObject(AppConstants.PAGINATION_DTO);
        if (paginationDTO != null) {
            Integer count = getCount(params);
            paginationDTO.setTotalRowCount(count);
        }
        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FIND, params);
    }

    private Integer getCount(Map<String, Object> params) {
        return getSqlSession().selectOne(CLASS_NAME + SQL_ID_FIND_COUNT, params);
    }

}
