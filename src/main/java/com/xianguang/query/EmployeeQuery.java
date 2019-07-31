package com.xianguang.query;

import com.github.wenhao.jpa.Specifications;
import com.xianguang.domain.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author wuxianguang
 */
public class EmployeeQuery extends BaseQuery {

    private String username;
    private String email;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public Specification createSpecification() {
        return Specifications.<Employee>and()
                .like(StringUtils.isNotBlank(username),"username","%"+username+"%")
                .like(StringUtils.isNotBlank(email),"email","%"+email+"%")
                .eq(age!=null,"age",age)
                .build();
    }
}
