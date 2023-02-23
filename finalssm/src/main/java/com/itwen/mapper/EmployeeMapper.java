package com.itwen.mapper;

import com.itwen.pojo.Employee;

import java.util.List;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/6 14:54
 * 文件描述：
 */
public interface EmployeeMapper {

    List<Employee> getAllEmployee();

    List<Employee> getEmployeeById();
}
