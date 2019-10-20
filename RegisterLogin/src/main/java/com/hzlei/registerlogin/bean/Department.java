package com.hzlei.registerlogin.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hzlei
 * @Package com.hzlei.registerlogin.bean
 * @date 2019/10/19 08:56
 * @Description: 部门类
 */
@Setter
@Getter
@ToString
public class Department {
    private Integer id;     // 部门id
    private String name;    // 部门名称
}
