package com.xianguang.repository;

import com.github.wenhao.jpa.Specifications;
import com.xianguang.domain.Employee;
import junit.extensions.TestSetup;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.rules.SpringClassRule;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.PrimitiveIterator;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EmployeeRepositoryTest {

    private static Logger logger = Logger.getLogger(Test.class);
    @Autowired
    private EmployeeRepository repository;

    @Test
    public void testSelect() {
        List<Employee> all = repository.findAll();
        all.forEach(e -> System.out.println(e));

    }

    @Test
    public void testCount() {
        long count = repository.count();
        System.out.println(count);
        logger.info("获取总条数成功：{}" + count);
    }

    @Test
    public void testPageQuery() {
        Pageable pageable = new PageRequest(0, 10);
        Page<Employee> page = repository.findAll(pageable);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        System.out.println(page.getSize());
        System.out.println(page.getContent());
        System.out.println(page.getNumberOfElements());

    }

    @Test
    public void testSort() {
        Sort sort = new Sort(Sort.Direction.DESC, "username");
        List<Employee> all = repository.findAll(sort);
        all.forEach(e -> {
            System.out.println(e);
        });
    }

    @Test
    public void testPageAndSort() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(0, 5, sort);

        Page<Employee> all = repository.findAll(pageable);
        all.forEach(e -> {
            System.out.println(e);
        });
    }

    @Test
    public void testDIY() {
        List<Employee> like = repository.findByUsernameLike("ad");
        System.out.println(like);
    }

    @Test
    public void testSpecification() {
        Specification<Employee> specification =
                Specifications.<Employee>and().like("username", "%7%").build();
        List<Employee> one = repository.findAll(specification);
        System.out.println(one);

    }
}