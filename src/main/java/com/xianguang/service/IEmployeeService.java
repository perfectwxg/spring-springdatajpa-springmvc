package com.xianguang.service;

import com.xianguang.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuxianguang
 */

public interface IEmployeeService {

    /**
     * 分页查询
     * @param pageNum 当前页
     * @param pageSize 页容量
     * @return
     */
    List<Employee> pageQuery(Integer pageNum,Integer pageSize);
}
