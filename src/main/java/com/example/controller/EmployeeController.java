package com.example.controller;

import com.example.dto.EmployeeDTO;
import com.example.pojo.Department;
import com.example.pojo.Employee;
import com.example.service.DepartmentService;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    //查询所有员工，返回列表页面
    @GetMapping("/emp")
    public String list(Model model){
        List<EmployeeDTO> employeeDTOS = employeeService.selectAllEmployeeDTO();
        model.addAttribute("emps", employeeDTOS);
        return "emp/list.html";
    }

    //to添加员工页面
    @GetMapping("/add")
    public String toAdd(Model model){
        List<Department> departments = departmentService.selectAllDepartment();
        model.addAttribute("departments", departments);
        return "emp/add.html";
    }

    @PostMapping("/add")
    public String add(Employee employee){
        System.out.println("*******************"+employee);
        employeeService.addEmployee(employee);
        return "redirect:/emp";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeService.selectEmployeeById(id);
        System.out.println("employee:"+employee);
        model.addAttribute("emp", employee);
        List<Department> departments = departmentService.selectAllDepartment();
        System.out.println("departments:"+departments);
        model.addAttribute("departments", departments);
        return "emp/update.html";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/emp";
    }

    @GetMapping("/delEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/emp";
    }
}
