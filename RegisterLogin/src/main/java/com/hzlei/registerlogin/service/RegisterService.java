package com.hzlei.registerlogin.service;

import com.hzlei.registerlogin.bean.Department;
import com.hzlei.registerlogin.bean.Staff;

import java.util.List;

/**
 * @author hzlei
 * @Package com.hzlei.registerlogin.service
 * @date 2019/10/19 14:38
 * @Description: 员工service
 */
public interface RegisterService {
    // add staff
    public String addStaff(Staff staff);
    // 注册时,判断手机号是否存在
    public Boolean telExist(String tel);
    // find all staff
    public List<Staff> findAllStaff();
    // find all department
    public List<Department> findAllDepartment();
}
