package com.hzlei.registerlogin.service.impl;

import com.hzlei.registerlogin.bean.Department;
import com.hzlei.registerlogin.bean.Staff;
import com.hzlei.registerlogin.mapper.RegisterMapper;
import com.hzlei.registerlogin.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hzlei
 * @Package com.hzlei.registerlogin.service.impl
 * @date 2019/10/19 14:39
 * @Description: 注册员工
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterMapper registerMapper;

    // add staff
    @Override
    public String addStaff(Staff staff) {
        int row = registerMapper.addStaff(staff);
        if (row > 0) return staff.getPassword();
        else return "fales";
    }

    // 注册时,判断手机号是否存在
    @Override
    public Boolean telExist(String tel) {
        Staff staff = registerMapper.telExist(tel);
        if (staff != null && staff.getTel().equals(tel))
            return true;
        else return false;

    }

    // find all staff
    @Override
    public List<Staff> findAllStaff() {
        return registerMapper.findAllStaff();
    }

    // find all department
    @Override
    public List<Department> findAllDepartment() {
        return registerMapper.findAllDepartment();
    }
}
