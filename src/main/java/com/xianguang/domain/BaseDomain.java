package com.xianguang.domain;

import javax.persistence.*;

/**
 * @author wuxianguang
 * @MappedSuperclass  表示不实例化到数据库、为一个父类
 */
@MappedSuperclass
public class BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

}
