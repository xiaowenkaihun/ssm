package com.itwen.controller;

import com.itwen.pojo.Employee;
import com.itwen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/5 10:44
 * 文件描述：
 * 查询所有的员工信息---> /employee-->get
 * 根据id查询员工信息---> /employee/1-->get
 * 跳转到添加页面----> /to/add-->get
 * 新增员工信息----> /employee-->post
 * 跳转到修改页面---> /employee/1-->get
 * 修改员工的信息---> /employee-->put
 * 删除员工信息---> /employee/1-->delete
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        List<Employee> employees = employeeService.getAllEmployee();
        // 将员工信息在请求域中共享
        model.addAttribute("employees", employees);
        // 跳转到employee_list.html
        return "employee_list";
    }
}

