package com.itwen.controller;

import com.github.pagehelper.PageInfo;
import com.itwen.pojo.Employee;
import com.itwen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    /*分页*/
    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum, Model model){
        // 获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);

        System.out.println(page);

        // 将分页数据共享到请求域当中
        model.addAttribute("page", page);
        return "employee_list";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeService.selectEmployeeByID(id);
        // 将员工的信息共享到请求域当中
        System.out.println(employee);
        model.addAttribute("employee", employee);
        // 转发or跳转到employee_update.html
        return "employee_update";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }
}

