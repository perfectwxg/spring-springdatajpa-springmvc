package com.xianguang.controller;

import com.xianguang.query.BaseQuery;
import com.xianguang.query.EmployeeQuery;
import com.xianguang.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wuxianguang
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/page")
    @ResponseBody
    public Object page(Integer currentPage,Integer pageSize){
        System.out.println(currentPage+","+pageSize);
        return employeeService.pageQuery(currentPage,pageSize);
    }
}
