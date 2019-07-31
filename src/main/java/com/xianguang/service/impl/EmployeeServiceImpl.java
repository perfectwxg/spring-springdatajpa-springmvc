package com.xianguang.service.impl;

import com.xianguang.domain.Employee;
import com.xianguang.repository.EmployeeRepository;
import com.xianguang.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> pageQuery(Integer pageNum, Integer pageSize) {
        Pageable pageable = new PageRequest(pageNum-1,pageSize);
        Page<Employee> all = employeeRepository.findAll(pageable);
        return all.getContent();
    }
}
