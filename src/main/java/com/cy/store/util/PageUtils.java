package com.cy.store.util;

import com.cy.store.entity.User;
import com.github.pagehelper.PageInfo;

public class PageUtils {
    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param page
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<User> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
