package com.example;

import com.example.dto.EmployeeDTO;
import com.example.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StaffManagementApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void contextLoads() {
        List<EmployeeDTO> employeeDTOS = employeeMapper.selectAllEmployeeDTO();
        System.out.println(employeeDTOS);
    }

}
