package com.hzlei.registerlogin.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hzlei
 * @Package com.hzlei.registerlogin.bean
 * @date 2019/10/19 08:50
 * @Description: 员工表
 */
@Setter
@Getter
@ToString
public class Staff {
    private Integer id;             // 员工id
    private String tel;             // 员工手机号
    private String password;        // 员工密码
    private Integer departmentId;   // 员工对应部门的id
    private Department department;  // 员工对应部门信息
}
