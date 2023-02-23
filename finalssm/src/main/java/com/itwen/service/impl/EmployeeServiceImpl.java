package com.itwen.service.impl;

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
}
