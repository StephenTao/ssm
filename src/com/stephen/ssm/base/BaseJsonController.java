package com.stephen.ssm.base;

import java.util.List;

import com.stephen.ssm.AppConstants;
import com.stephen.ssm.AppContext;
import com.stephen.ssm.dto.PaginationDTO;

public class BaseJsonController extends BaseController {

    protected PaginationDTO<?> pagination(Integer currentPage,
            PaginationCallBack<?> paginationCallback) {
        return paginationCallback.execute(currentPage, null);
    }

    protected PaginationDTO<?> pagination(Integer currentPage, Integer pageSize,
            PaginationCallBack<?> paginationCallBack) {
        return paginationCallBack.execute(currentPage, pageSize);
    }

    protected abstract class PaginationCallBack<T> {
        public PaginationDTO<T> execute(Integer currentPage, Integer pageSize) {
            PaginationDTO<T> paginationDTO = new PaginationDTO<T>();
            AppContext.getContext().addObject(AppConstants.PAGINATION_DTO, paginationDTO);
            paginationDTO.setCurrentPage(currentPage);
            if (pageSize != null) {
                paginationDTO.setPageSize(pageSize);
            }
            List<T> itemList = callBack();
            paginationDTO.setItemList(itemList);
            return paginationDTO;
        }

        abstract public List<T> callBack();
    }
}
