package com.itwen.service;

import com.github.pagehelper.PageInfo;
import com.itwen.pojo.Employee;

import java.util.List;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/5 11:15
 * 文件描述：
 */
public interface EmployeeService {
    List<Employee> getAllEmployee();

    void addEmployee(Employee employee);
    Employee selectEmployeeByID(Integer id);

    void updateEmployee(Employee employee);
    void deleteEmployee(Integer id);

    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
