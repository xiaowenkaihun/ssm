package com.itwen.mapper;

import com.itwen.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/6 14:54
 * 文件描述：
 */
public interface EmployeeMapper {
    List<Employee> getAllEmployee();
    void addEmployee(Employee employee);

    Employee selectEmployeeById(@Param("id") Integer id);

    void updateEmployee(Employee employee);

    void deleteEmployee(@Param("id") Integer id);
}
