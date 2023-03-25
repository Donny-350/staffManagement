package com.example.service;

import com.example.mapper.DepartmentMapper;
import com.example.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectAllDepartment() {
        return departmentMapper.selectAllDepartment();
    }
}
