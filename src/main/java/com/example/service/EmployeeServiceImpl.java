package com.example.service;

import com.example.dto.EmployeeDTO;
import com.example.mapper.EmployeeMapper;
import com.example.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> selectAllEmployeeDTO() {
        return employeeMapper.selectAllEmployeeDTO();
    }

    @Override
    public Employee selectEmployeeById(int id) {
        return employeeMapper.selectEmployeeById(id);
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public int deleteEmployee(int id) {
        return employeeMapper.deleteEmployee(id);
    }
}
