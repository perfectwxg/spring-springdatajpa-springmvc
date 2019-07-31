package com.xianguang.query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 * 公共的条件与规范
 */
public abstract class BaseQuery {

    //当前页(从1开始)
    private int currentPage = 1;
    //每页条数
    private int pageSize = 10;

    //排序方式 ASC/DESC
    private String orderByType ="ASC";
    //排序字段
    private String orderByName;


    /**
     * 查询规则创建对象、由子类实现确定规则
     * @return
     */
    public abstract Specification createSpecification();

    /**
     * 确定是否具有排序功能，通过是否传入排序字段来判断
     * @return
     */
    public Sort createSort() {
        Sort sort = null;
        if (StringUtils.isNotBlank(orderByName)) {
            Sort.Direction type=  "ASC".equals(orderByType.toUpperCase())? Sort.Direction.ASC:Sort.Direction.DESC;
            sort = new Sort(type,orderByName);
        }
        return sort;
    }


    public int getCurrentPage() {
        return currentPage;
    }
    /**
     * 专门准备的方法，因为前台用户传的是从第1页开始，而我们后台分页又是从0开的
     * @return
     */
    public int getJpaPage() {
        return currentPage - 1;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public String getOrderByType() {
        return orderByType;
    }

    public void setOrderByType(String orderByType) {
        this.orderByType = orderByType;
    }

    public String getOrderByName() {
        return orderByName;
    }

    public void setOrderByName(String orderByName) {
        this.orderByName = orderByName;
    }
}