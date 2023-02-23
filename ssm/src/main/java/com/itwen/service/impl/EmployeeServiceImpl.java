package com.itwen.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itwen.mapper.EmployeeMapper;
import com.itwen.pojo.Employee;
import com.itwen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/5 11:16
 * 文件描述：
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {

        return employeeMapper.getAllEmployee();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public Employee selectEmployeeByID(Integer id) {
        return employeeMapper.selectEmployeeById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeMapper.deleteEmployee(id);
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        // 开启分页功能
        PageHelper.startPage(pageNum, 8);
        // 查询所有的员工信息
        List<Employee> allEmployee = employeeMapper.getAllEmployee();
        // 获取分页的相关数据
        PageInfo<Employee> page = new PageInfo<>(allEmployee, 3);
        return page;
    }


}
