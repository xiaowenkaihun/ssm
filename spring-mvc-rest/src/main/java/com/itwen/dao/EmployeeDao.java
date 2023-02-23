package com.itwen.dao;

import com.itwen.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/31 19:28
 * 文件描述：
 */


@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1));
        employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1));
        employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0));
        employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0));
        employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1));
    }

    private static Integer initId = 1006;

    public void save(Employee employee) {
        // 添加功能
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        // 修改功能
        employees.put(employee.getId(), employee);
    }

    // 查询所有
    public Collection<Employee> getAll() {
        return employees.values();
    }
    // 通过id获得某一个员工的信息
    public Employee get(Integer id) {
        return employees.get(id);
    }

    // 通过id删除一个员工
    public void delete(Integer id) {
        employees.remove(id);
    }
}