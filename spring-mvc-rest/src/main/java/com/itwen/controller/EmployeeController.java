package com.itwen.controller;

import com.itwen.dao.EmployeeDao;
import com.itwen.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/31 19:34
 * 文件描述：
 * 查询所有的员工信息---> /employee-->get
 * 跳转到添加页面----> /to/add-->get
 * 新增员工信息----> /employee-->post
 * 跳转到修改页面---> /employee/1-->get
 * 修改员工的信息---> /employee-->put
 * 删除员工信息---> /employee/1-->delete
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public ModelAndView getAllEmployee(){
        // 获取所有的员工信息
        Collection<Employee> employees = employeeDao.getAll();
        // 创建ModelAndView的对象
        ModelAndView modelAndView = new ModelAndView();
        // 请求域共享
        modelAndView.addObject("employees", employees);
        modelAndView.setViewName("employeeList");
        return modelAndView;
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        // 保存员工信息
        employeeDao.save(employee);
        // 跳转列表功能，展示所有的信息
        // 重定向到列表功能
        return "redirect:/employee";

    }

    @GetMapping ("/employee/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        // 将员工的信息共享到请求域当中
        model.addAttribute("employee", employee);
        // 转发or跳转到employee_update.html
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
