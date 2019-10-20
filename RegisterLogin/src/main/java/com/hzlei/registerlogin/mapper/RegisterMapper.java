package com.hzlei.registerlogin.mapper;

import com.hzlei.registerlogin.bean.Department;
import com.hzlei.registerlogin.bean.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hzlei
 * @Package com.hzlei.registerlogin.mapper
 * @date 2019/10/19 10:19
 * @Description: 员工mapper
 */
@Component
@Mapper
public interface RegisterMapper {
    // 注册时,判断手机号是否存在
    public Staff telExist(String tel);
    // add staff
    public Integer addStaff(Staff staff);
    // find all staff
    public List<Staff> findAllStaff();
    // find all department
    public List<Department> findAllDepartment();

}
