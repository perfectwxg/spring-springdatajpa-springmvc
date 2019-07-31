package com.xianguang.repository;

import com.xianguang.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wuxianguang
 */
public interface EmployeeRepository extends JpaRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {

    /**
     * 根据用户名查询员工信息
     * @return
     * @throws Exception
     */
    Employee findEmployeeByUsername(String usrname);
    List<Employee> findByUsernameLike(String keyword);
}
